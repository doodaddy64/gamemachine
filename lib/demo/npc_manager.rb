require_relative 'npc_actor'

module Demo
  class NpcManager < GameMachine::Actor::Base
    
    aspect %w(CreateNpc)

    def post_init(*args)
      @scheduler = get_context.system.scheduler
      @dispatcher = get_context.system.dispatcher
      @actor_refs = GameMachine::Actor::Builder.new(Demo::NpcActor).distributed(100).start
      GameMachine.logger.info("#{@actor_refs.size} npc actos started")
      @npc_actors = {}
      400.times do |i|
        create_npc(i)
      end
      #node1 = JavaLib::Node.new(0,0)
      #node2 = JavaLib::Node.new(390,390)
      #finder = JavaLib::Pathfinding.new(JavaLib::Pathfinding::Algorithm::ASTAR,Grid.new)
      #finder.set_eight(true)
      #result = finder.find_path(node1,node2)
      schedule_update
    end

    def on_receive(message)
      if message.is_a?(String)
        if message == 'update'
          @actor_refs.each {|actor_ref| actor_ref.tell('update',nil)}
        end
      elsif message.has_create_npc
        ref = Demo::NpcActor.find_distributed(message.create_npc.npc.id)
        ref.tell(message)
      end
      GameMachine.logger.debug("NpcManager got #{message}")
    end

    def create_npc(id)
      max = GameMachine::Settings.world_grid_size - 10

      x = rand(max) + 1
      y = rand(max) + 1
      z = 0.10
      entity = Entity.new.set_id('0').set_create_npc(
        CreateNpc.new.set_npc(
          Npc.new.set_id(id.to_s).set_transform(
            Transform.new.set_vector3(
              Vector3.new.set_x(x).set_y(y).set_z(z)
            )
          )
        )
      )
      self.class.find.tell(entity)
    end

    def schedule_update
      duration = GameMachine::JavaLib::Duration.create(200, java.util.concurrent.TimeUnit::MILLISECONDS)
      @scheduler.schedule(duration, duration, get_self, "update", @dispatcher, nil)
    end

  end
end
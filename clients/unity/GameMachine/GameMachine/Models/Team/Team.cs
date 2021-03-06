﻿using System.Collections;
using System;
using  System.Collections.Generic;
using GameMachine;
using GameMachine.Core;
using Newtonsoft.Json;

namespace GameMachine.Models.Team
{
	
    public class Team : JsonModel
    {
        public string name { get; set; }
        public string team_id { get; set; }
        public string owner { get; set; }
        public string access { get; set; }
        public List<string> members { get; set; }
        public string invite_id { get; set; }
        public string match_server { get; set; }
        public string match_id { get; set; }
        public int max_members { get; set; }
        public bool destroy_on_owner_leave { get; set; }
        public bool locked { get; set; }
        public int min_for_match { get; set; }

		

        public static void Receive (string json)
        {
            Team team = JsonConvert.DeserializeObject < Team > (json);
            TeamsManager.Instance.teamReceived (team);
        }
		
        public override string ToJson ()
        {
            return JsonConvert.SerializeObject (this, Formatting.Indented);
        }
    }
}
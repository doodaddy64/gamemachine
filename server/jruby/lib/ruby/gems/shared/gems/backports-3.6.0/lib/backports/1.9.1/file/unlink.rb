if RUBY_VERSION < '1.9'
  require 'backports/tools'

  Backports.convert_all_arguments_to_path File, :unlink, 0
end

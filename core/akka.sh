#!/usr/bin/env bash

declare quiet="false"

while true; do
  case "$1" in
    -q | --quiet ) quiet="true"; shift ;;
    * ) break ;;
  esac
done

[[ "$@" ]] || {
  echo "No boot classes specified"
  echo "Usage: bin/akka org.somewhere.BootClass"
  exit 1
}

declare AKKA_HOME="$(cd "$(cd "$(dirname "$0")"; pwd -P)"/..; pwd)"

[ -n "$JAVA_OPTS" ] || JAVA_OPTS="-Xms1024M -Xmx1024M -Xss1M -XX:MaxPermSize=256M -XX:+UseParallelGC"

[ -n "$AKKA_CLASSPATH" ] || AKKA_CLASSPATH="$AKKA_HOME/java_lib/scala-library.jar:$AKKA_HOME/config:$AKKA_HOME/java_lib/*"

java $JAVA_OPTS -cp "$AKKA_CLASSPATH" -Dakka.home="$AKKA_HOME" -Dakka.kernel.quiet=$quiet com.game_machine.GameMachine "$@"

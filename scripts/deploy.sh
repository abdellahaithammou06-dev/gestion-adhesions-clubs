#!/usr/bin/env bash
set -e
TOMCAT="${TOMCAT_HOME:-$HOME/tools/tomcat}"
mvn -q clean package
"$TOMCAT/bin/shutdown.sh" 2>/dev/null || true
sleep 3
rm -rf "$TOMCAT/webapps/adhesions" "$TOMCAT/webapps/adhesions.war"
cp target/adhesions.war "$TOMCAT/webapps/"
"$TOMCAT/bin/startup.sh"
echo "Logs : tail -f $TOMCAT/logs/catalina.out"

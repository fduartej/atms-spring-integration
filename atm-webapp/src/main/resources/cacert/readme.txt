Install Certificate from the service https://www.ing.nl/api/locator/atms/

1. GO TO CMD ENTER TO
   JAVA_HOME\bin
2. EXECUTE 
   keytool -importcert -file www.ing.nl.crt -keypass changeit -keystore "JAVA_HOME\jre\lib\security\cacerts"

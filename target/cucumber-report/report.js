$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/login.feature");
formatter.feature({
  "name": "Test Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "log in functionality",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@demo"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs into \"admin\" account",
  "keyword": "Given "
});
formatter.match({
  "location": "logIn_Steps.user_logs_into_account(String)"
});
formatter.write("2021-05-29 22:06:20: PASS: Pressed Log in");
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "status": "passed"
});
});
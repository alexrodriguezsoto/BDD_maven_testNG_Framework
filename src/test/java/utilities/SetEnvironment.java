package utilities;


public class SetEnvironment {

    private static String env = null;


    public static String getEnvironmentUrl() {

        env = System.getProperty("env");
        if (env == null) {
            env = ConfigurationReader.getProperty("environment");
        }

        System.out.println(env);
        switch (env.toUpperCase()) {
            case "PROD":
                return ConfigurationReader.getProperty("PROD_URL");
            case "QA":
                return ConfigurationReader.getProperty("QA_URL");
            default:
                return ConfigurationReader.getProperty("DEV_URL");
        }
    }
}
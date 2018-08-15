package simbot_core;

public class Setting {
    private static AbstractEnv env;

    /**
     * This method is to specified the {@link AbstractEnv} to be used in the {@link AbstractSimulation}
     * @param env the {@link AbstractEnv} to be used in the {@link AbstractSimulation}
     */
    public static void setEnv(AbstractEnv env) {
        Setting.env = env;
    }

    /**
     * @return the {@link AbstractEnv} object
     */
    static AbstractEnv getEnv() {
        if (env == null) {
            throw new IllegalStateException("Please specify the environment before the simulation starts");
        }
        return env;
    }
}

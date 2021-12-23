package com.s3rd.java.database;

import java.io.InputStream;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class DatabaseConfiguration {
        private String configFilePath = "database.credential.yml";
        protected String database;
        protected String password;
        protected String username;
        public String connectionType;
        public String host;
        public Integer port;

        public DatabaseConfiguration() {
                this.loadConfig();
        }

        private void loadConfig() {
                Map<String, Map<String, Object>> configMaps = new Yaml().load(this.getConfigFile());

                this.connectionType = (String) configMaps.keySet().toArray()[0];

                Map<String, Object> configDetails;
                configDetails = (Map<String, Object>) configMaps.get(this.connectionType);

                this.database = (String) configDetails.get("database");
                this.password = (String) configDetails.get("password");
                this.username = (String) configDetails.get("username");
                this.host = (String) configDetails.get("host");
                this.port = (Integer) configDetails.get("port");
        }

        private InputStream getConfigFile() {
                return getClass()
                                .getClassLoader()
                                .getResourceAsStream(this.configFilePath);
        }

        @Override
        public String toString() {
                return String.format("jdbc:%s://%s:%d/%s", this.connectionType, this.host, this.port, this.database);
        }
}

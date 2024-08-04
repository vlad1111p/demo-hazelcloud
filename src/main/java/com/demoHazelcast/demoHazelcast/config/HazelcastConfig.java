package com.demoHazelcast.demoHazelcast.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setInstanceName("demoHazelcast-instance");
        config.getJetConfig().setEnabled(true);

        NetworkConfig networkConfig = config.getNetworkConfig();
        JoinConfig joinConfig = networkConfig.getJoin();

        // Enable Kubernetes-based discovery for OpenShift
        joinConfig.getKubernetesConfig().setEnabled(true);

        return Hazelcast.newHazelcastInstance(config);
    }
}

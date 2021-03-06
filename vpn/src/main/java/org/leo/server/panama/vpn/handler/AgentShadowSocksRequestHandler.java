package org.leo.server.panama.vpn.handler;

import io.netty.channel.Channel;
import org.leo.server.panama.vpn.configuration.ShadowSocksConfiguration;
import org.leo.server.panama.vpn.proxy.TCPProxy;
import org.leo.server.panama.vpn.proxy.factory.ShadowSocksProxyFactory;

public class AgentShadowSocksRequestHandler extends ShadowSocksRequestHandler {
    public AgentShadowSocksRequestHandler(ShadowSocksConfiguration shadowSocksConfiguration) {
        super(shadowSocksConfiguration);
    }

    @Override
    protected TCPProxy createProxy(Channel channel, ShadowSocksConfiguration shadowSocksConfiguration) {
        return ShadowSocksProxyFactory.createAgentShadowSocksProxy(
                channel,
                () -> this.close(channel),
                shadowSocksConfiguration);
    }
}

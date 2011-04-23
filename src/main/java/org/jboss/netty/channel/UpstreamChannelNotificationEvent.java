package org.jboss.netty.channel;
/*
 * Copyright 2009 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
import com.sun.nio.sctp.Notification;

/**
 *
 * @author <a href="http://www.jboss.org/netty/">The Netty Project</a>
 * @author Jestan Nirojan
 *
 * @version $Rev$, $Date$
 *
 */
public class UpstreamChannelNotificationEvent implements ChannelEvent {
    private Channel channel;
    private Notification notification;
    private Object value;

    public UpstreamChannelNotificationEvent(Channel channel, Notification notification, Object value) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        if (notification == null) {
            throw new NullPointerException("notification");
        }
        if (value == null) {
            throw new NullPointerException("value");
        }

        this.channel = channel;
        this.notification = notification;
        this.value = value;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    @Override
    public ChannelFuture getFuture() {
        return Channels.succeededFuture(channel);
    }

    public Notification getNotification() {
        return notification;
    }

    public Object getValue() {
        return value;
    }
}

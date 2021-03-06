/*
 * Copyright 2013-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.configuration.server;

import com.autonomy.aci.client.transport.AciServerDetails;
import org.mockito.ArgumentMatcher;

class IsAciServerDetails extends ArgumentMatcher<AciServerDetails> {
    private final String host;
    private final int port;

    IsAciServerDetails(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public boolean matches(final Object o) {
        if (!(o instanceof AciServerDetails)) {
            return false;
        }

        final AciServerDetails serverDetails = (AciServerDetails) o;

        boolean result = true;

        if (host != null) {
            result = host.equals(serverDetails.getHost());
        }

        if (port != -1) {
            result = result && port == serverDetails.getPort();
        }

        return result;
    }
}

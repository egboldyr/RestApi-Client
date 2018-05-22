package com.rest.client.config.resource;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EGBoldyr on 22.05.18.
 */
public class NaiveHostnameVerifier implements HostnameVerifier {

    private final Set<String> naivelyTrustedHostnames;
    private final HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

    public NaiveHostnameVerifier(String ... naivelyTrustedHostnames) {
        this.naivelyTrustedHostnames =
                Collections.unmodifiableSet(new HashSet(Arrays.asList(naivelyTrustedHostnames)));
    }

    public boolean verify(String hostname, SSLSession session) {
        return naivelyTrustedHostnames.contains(hostname) || hostnameVerifier.verify(hostname, session);
    }
}

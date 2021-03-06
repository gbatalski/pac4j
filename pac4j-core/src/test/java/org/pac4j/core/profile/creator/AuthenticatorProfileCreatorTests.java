package org.pac4j.core.profile.creator;

import org.junit.Test;
import org.pac4j.core.credentials.Credentials;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.util.TestsConstants;

import static org.junit.Assert.*;

/**
 * This class tests the {@link AuthenticatorProfileCreator}.
 * 
 * @author Jerome Leleu
 * @since 1.8.0
 */
public final class AuthenticatorProfileCreatorTests implements TestsConstants {

    @Test
    public void testReturnNoProfile() throws HttpAction {
        assertNull(AuthenticatorProfileCreator.INSTANCE.create(new TokenCredentials(TOKEN, CLIENT_NAME), null));
    }

    @Test
    public void testReturnProfile() throws HttpAction {
        final CommonProfile profile = new CommonProfile();
        final Credentials credentials = new TokenCredentials(TOKEN, CLIENT_NAME);
        credentials.setUserProfile(profile);
        final CommonProfile profile2 = AuthenticatorProfileCreator.INSTANCE.create(credentials, null);
        assertEquals(profile, profile2);
    }
}

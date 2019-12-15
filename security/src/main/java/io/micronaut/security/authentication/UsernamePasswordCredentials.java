/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.security.authentication;

import io.micronaut.core.annotation.Introspected;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sergio del Amo
 * @since 1.0
 */
@Introspected
public class UsernamePasswordCredentials implements Serializable, AuthenticationRequest<String, String> {

    @NotBlank
    @NotNull
    private String username;

    @NotBlank
    @NotNull
    private char[] password;

    /**
     * Empty constructor.
     */
    public UsernamePasswordCredentials() { }

    /**
     *
     * @param username e.g. admin
     * @param password raw password
     */
    public UsernamePasswordCredentials(final String username, final char[] password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @param username e.g. admin
     * @param password raw password
     * @deprecated Use {@link #UsernamePasswordCredentials(String, char[])} instead
     */
    @Deprecated
    public UsernamePasswordCredentials(String username, String password) {
        this.username = username;
        this.password = password != null ? password.toCharArray() : null;
    }

    /**
     * username getter.
     * @return e.g. admin
     */
    public String getUsername() {
        return username;
    }

    /**
     * username setter.
     * @param username e.g. admin
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * password getter.
     * @return raw password
     * @deprecated Use {@link #getPasswordArray()} instead
     */
    @Deprecated
    public String getPassword() {
        return this.password != null ? String.valueOf(this.password) : null;
    }

    /**
     * password setter.
     * @param password raw password
     * @deprecated Use {@link #setPassword(char[])} instead
     */
    @Deprecated
    public void setPassword(String password) {
        this.password = password.toCharArray();
    }

    /**
     * password getter.
     * @return raw password
     */
    public char[] getPasswordArray() {
        return this.password;
    }

    /**
     * password setter.
     * @param password raw password
     */
    public void setPassword(final char[] password) {
        this.password = password;
    }

    @Override
    public String getIdentity() {
        return getUsername();
    }

    /**
     * Returns password conforming to {@link AuthenticationRequest} blueprint.
     * @return secret string.
     */
    @Override
    public String getSecret() {
        return this.password != null ? String.valueOf(this.password) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsernamePasswordCredentials that = (UsernamePasswordCredentials) o;

        if (username != null ? !username.equals(that.username) : that.username != null) {
            return false;
        }
        return this.password != null ? Objects.deepEquals(this.password, that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(this.password);
        return result;
    }

}

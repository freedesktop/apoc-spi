/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either
 * the GNU General Public License Version 2 only ("GPL") or
 * the Common Development and Distribution License("CDDL")
 * (collectively, the "License"). You may not use this file
 * except in compliance with the License. You can obtain a copy
 * of the License at www.sun.com/CDDL or at COPYRIGHT. See the
 * License for the specific language governing permissions and
 * limitations under the License. When distributing the software,
 * include this License Header Notice in each file and include
 * the License file at /legal/license.txt. If applicable, add the
 * following below the License Header, with the fields enclosed
 * by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by
 * only the CDDL or only the GPL Version 2, indicate your
 * decision by adding "[Contributor] elects to include this
 * software in this distribution under the [CDDL or GPL
 * Version 2] license." If you don't indicate a single choice
 * of license, a recipient has the option to distribute your
 * version of this file under either the CDDL, the GPL Version
 * 2 or to extend the choice of license to its licensees as
 * provided above. However, if you add GPL Version 2 code and
 * therefore, elected the GPL Version 2 license, then the
 * option applies only if the new code is made subject to such
 * option by the copyright holder.
 */
package com.sun.apoc.spi;

public class AuthenticationException extends ConnectionException {

    private static final String AUTHENTICATION_KEY = 
        "error.spi.connection.authentication";
    private static final String NOT_ALLOWED_AUTHENTICATION_KEY = 
        "error.spi.connection.authentication.notallowed";

    protected String mUserName = null;

    public AuthenticationException () {
        super();
    }

    public AuthenticationException (String url, String userName) {
        super(url);
		mUserName = userName;
		mMessageKey = NOT_ALLOWED_AUTHENTICATION_KEY;
		mMessageParams = new Object[]{mUrl, mUserName};
	}

    public AuthenticationException (String url, Throwable cause) {
		super(url, cause);
		mMessageKey = AUTHENTICATION_KEY;
	}

    public AuthenticationException (String url, String userName,
            						Throwable cause) {
        super(url, cause);
        mUserName = userName;
        mMessageKey = AUTHENTICATION_KEY;
        mMessageParams = new Object[]{mUrl, mUserName};
    }
    
    public String getUserName() { return mUserName; }
}

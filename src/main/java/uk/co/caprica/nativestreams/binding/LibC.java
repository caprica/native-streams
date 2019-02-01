/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2009-2019 Caprica Software Limited.
 */

package uk.co.caprica.nativestreams.binding;

import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;

/**
 * Minimal interface to the standard "C" library.
 */
public class LibC {

    static {
        Native.register(Platform.isWindows() ? "msvcrt" : "c");
    }

    /**
     * Open a stream for a file descriptor.
     *
     * @param filedes file descriptor
     * @param mode open mode
     * @return file descriptor; or <code>NULL</code>, setting <code>errno</code> to an error code
     */
    public static native Pointer fdopen(int filedes, String mode);

    /**
     * Associate an existing stream to a new file.
     *
     * @param path new file path
     * @param mode open mode
     * @param stream file stream
     * @return file descriptor; or <code>NULL</code>, setting <code>errno</code> to an error code
     */
    public static native Pointer freopen(String path, String mode, Pointer stream);

    /**
     * Close a file stream.
     *
     * @param stream stream
     * @return 0 if successful; -1 if not, setting <code>errno</code> to an error code
     */
    public static native int fclose(Pointer stream);

}

/*
 * Copyright 2006, XpertNet SARL, and individual contributors as indicated
 * by the contributors.txt.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *
 * @author sdumitriu
 */


package com.xpn.xwiki.api;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.doc.XWikiAttachment;
import org.suigeneris.jrcs.rcs.Archive;
import org.suigeneris.jrcs.rcs.Version;

import java.util.Date;
import java.util.List;

public class Attachment extends Api {
    private Document doc;
    private XWikiAttachment attachment;

    public Attachment(Document doc, XWikiAttachment attachment, XWikiContext context) {
       super(context);
       this.doc = doc;
       this.attachment = attachment;
    }

    /**
     *
     * @return the document the file is attached to
     */
    public Document getDocument() {
        return doc;
    }


    /**
     *
     * @return the document Id of the attachment
     */
    public long getId() {
        return attachment.getId();
    }

    /**
     *
     * @return the id of the document the file is attached to
     */
    public long getDocId() {
        return doc.getId();
    }


    /**
     *
     * @return the Attachment size
     */
    public int getFilesize() {
        return attachment.getFilesize();
    }

    /**
     *
     * @return the attachment name
     */
    public String getFilename() {
        return attachment.getFilename();
    }

    /**
     *
     * @return the login of the person who attach the file
     */
    public String getAuthor() {
        return attachment.getAuthor();
    }

    /**
     *
     * @return the last version number of the document
     */
    public String getVersion() {
        return attachment.getVersion();
    }

     /**
     *
     * @return the RCS object version of the document
     */
    public Version getRCSVersion() {
         return attachment.getRCSVersion();
    }

    /**
     *
     * @return the list of comments
     */
    public String getComment() {
        return attachment.getComment();
    }

    /**
     *
     * @return the date of the last uploaded version
     */
    public Date getDate() {
        return attachment.getDate();
    }

    /**
     *
     * @return the content of the attachment
     * @throws XWikiException
     */
    public byte[] getContent() throws XWikiException {
        return attachment.getContent(context);
    }

    /**
     *
     * @return the rcs archive of the attachement
     */
    public Archive getArchive() {
        return attachment.getArchive();
    }

    public Version[] getVersions() throws XWikiException {
        attachment.loadArchive(context);
        return attachment.getVersions();
    }

    /**
     *
     * @return a list of string with all the versions number in String
     * @throws XWikiException
     */
    public List getVersionList() throws XWikiException {
        attachment.loadArchive(context);
        return attachment.getVersionList();
    }

    /**
     *
     * @return the XWikiAttachment object (without the wrapping) if you have the programming right
     * @see XWikiAttachment
     */
    public XWikiAttachment getAttachment() {
        if (hasProgrammingRights())
            return attachment;
        else
            return null;
    }

    /**
     *
     * @return the mimetype of the attachment
     */
    public String getMimeType() {
        return attachment.getMimeType(context);
    }

    /**
     *
     * @return true if it's an image
     */
    public boolean isImage() {
        return attachment.isImage(context);
    }

     public XWikiAttachment getAttachmentRevision(String rev) throws XWikiException{
        return attachment.getAttachmentRevision(rev, context);
    }
}

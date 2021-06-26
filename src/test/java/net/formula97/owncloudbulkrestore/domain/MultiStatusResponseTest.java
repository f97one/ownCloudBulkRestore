package net.formula97.owncloudbulkrestore.domain;

import jakarta.xml.bind.JAXB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.StringReader;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class MultiStatusResponseTest {

    @Test
    @DisplayName("MultiStatusレスポンスをアンマーシャルできる")
    void canUnmarshalResponse() {
        String respBody = "<?xml version=\"1.0\"?>\n" +
                "<d:multistatus xmlns:d=\"DAV:\" xmlns:s=\"http://sabredav.org/ns\" xmlns:oc=\"http://owncloud.org/ns\">\n" +
                "  <d:response>\n" +
                "    <d:href>/remote.php/dav/trash-bin/admin/</d:href>\n" +
                "    <d:propstat>\n" +
                "      <d:prop>\n" +
                "        <d:resourcetype>\n" +
                "          <d:collection/>\n" +
                "        </d:resourcetype>\n" +
                "      </d:prop>\n" +
                "      <d:status>HTTP/1.1 200 OK</d:status>\n" +
                "    </d:propstat>\n" +
                "    <d:propstat>\n" +
                "      <d:prop>\n" +
                "        <oc:trashbin-original-filename/>\n" +
                "        <oc:trashbin-original-location/>\n" +
                "        <oc:trashbin-delete-datetime/>\n" +
                "        <d:getcontentlength/>\n" +
                "      </d:prop>\n" +
                "      <d:status>HTTP/1.1 404 Not Found</d:status>\n" +
                "    </d:propstat>\n" +
                "  </d:response>\n" +
                "  <d:response>\n" +
                "    <d:href>/remote.php/dav/trash-bin/admin/23/</d:href>\n" +
                "    <d:propstat>\n" +
                "      <d:prop>\n" +
                "        <oc:trashbin-original-filename>nest1</oc:trashbin-original-filename>\n" +
                "        <oc:trashbin-original-location>nest1</oc:trashbin-original-location>\n" +
                "        <oc:trashbin-delete-datetime>Sat, 26 Jun 2021 09:57:41 GMT</oc:trashbin-delete-datetime>\n" +
                "        <d:resourcetype>\n" +
                "          <d:collection/>\n" +
                "        </d:resourcetype>\n" +
                "      </d:prop>\n" +
                "      <d:status>HTTP/1.1 200 OK</d:status>\n" +
                "    </d:propstat>\n" +
                "    <d:propstat>\n" +
                "      <d:prop>\n" +
                "        <d:getcontentlength/>\n" +
                "      </d:prop>\n" +
                "      <d:status>HTTP/1.1 404 Not Found</d:status>\n" +
                "    </d:propstat>\n" +
                "  </d:response>\n" +
                "  <d:response>\n" +
                "    <d:href>/remote.php/dav/trash-bin/admin/23/24/</d:href>\n" +
                "    <d:propstat>\n" +
                "      <d:prop>\n" +
                "        <oc:trashbin-original-filename>nest2</oc:trashbin-original-filename>\n" +
                "        <oc:trashbin-original-location>nest1/nest2</oc:trashbin-original-location>\n" +
                "        <oc:trashbin-delete-datetime>Sat, 26 Jun 2021 09:57:41 GMT</oc:trashbin-delete-datetime>\n" +
                "        <d:resourcetype>\n" +
                "          <d:collection/>\n" +
                "        </d:resourcetype>\n" +
                "      </d:prop>\n" +
                "      <d:status>HTTP/1.1 200 OK</d:status>\n" +
                "    </d:propstat>\n" +
                "    <d:propstat>\n" +
                "      <d:prop>\n" +
                "        <d:getcontentlength/>\n" +
                "      </d:prop>\n" +
                "      <d:status>HTTP/1.1 404 Not Found</d:status>\n" +
                "    </d:propstat>\n" +
                "  </d:response>\n" +
                "  <d:response>\n" +
                "    <d:href>/remote.php/dav/trash-bin/admin/23/25/</d:href>\n" +
                "    <d:propstat>\n" +
                "      <d:prop>\n" +
                "        <oc:trashbin-original-filename>nest3</oc:trashbin-original-filename>\n" +
                "        <oc:trashbin-original-location>nest1/nest3</oc:trashbin-original-location>\n" +
                "        <oc:trashbin-delete-datetime>Sat, 26 Jun 2021 09:57:41 GMT</oc:trashbin-delete-datetime>\n" +
                "        <d:resourcetype>\n" +
                "          <d:collection/>\n" +
                "        </d:resourcetype>\n" +
                "      </d:prop>\n" +
                "      <d:status>HTTP/1.1 200 OK</d:status>\n" +
                "    </d:propstat>\n" +
                "    <d:propstat>\n" +
                "      <d:prop>\n" +
                "        <d:getcontentlength/>\n" +
                "      </d:prop>\n" +
                "      <d:status>HTTP/1.1 404 Not Found</d:status>\n" +
                "    </d:propstat>\n" +
                "  </d:response>\n" +
                "  <d:response>\n" +
                "    <d:href>/remote.php/dav/trash-bin/admin/23/25/26</d:href>\n" +
                "    <d:propstat>\n" +
                "      <d:prop>\n" +
                "        <oc:trashbin-original-filename>testfile2.txt</oc:trashbin-original-filename>\n" +
                "        <oc:trashbin-original-location>nest1/nest3/testfile2.txt</oc:trashbin-original-location>\n" +
                "        <oc:trashbin-delete-datetime>Sat, 26 Jun 2021 09:57:41 GMT</oc:trashbin-delete-datetime>\n" +
                "        <d:getcontentlength>24</d:getcontentlength>\n" +
                "        <d:resourcetype/>\n" +
                "      </d:prop>\n" +
                "      <d:status>HTTP/1.1 200 OK</d:status>\n" +
                "    </d:propstat>\n" +
                "  </d:response>\n" +
                "</d:multistatus>";

        MultiStatusResponse resp = JAXB.unmarshal(new StringReader(respBody), MultiStatusResponse.class);

        assertNotNull(resp);
        assertEquals(5, resp.getResponse().size());

        Optional<MultiStatusResponse.Response> responseOptional = resp.getResponse().stream().filter(r -> r.getPropStat().size() == 1).findFirst();
        assertTrue(responseOptional.isPresent());

        WebDavPropStat propStat = responseOptional.get().getPropStat().get(0);
        assertEquals("testfile2.txt", propStat.getProp().getTrashbinOriginalFilename());
        assertEquals("nest1/nest3/testfile2.txt", propStat.getProp().getTrashbinOriginalLocation());
        assertEquals(24, propStat.getProp().getContentLength());
        assertNull(propStat.getProp().getResourceType().getCollection());
    }
}
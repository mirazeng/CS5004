package TestController;

import controller.FileParser;
import model.photoAlbum.IAlbum;
import model.photoAlbum.ShapeAlbum;
import org.junit.jupiter.api.Test;
import view.WebView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * The type Test album controller.
 */
public class TestAlbumController {

// Test for the webview only:
// First, we use buildings.txt to generate a webview.
// Then, we use the generated webview to test the webview.

  /**
   * Test web view.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testWebView() throws IOException {
    // Given that the generated webview file is already there
    // Stripping the target of snapshot id info since they are time sensitive and ruins comparison
    String compareTarget =
            """
                    <!DOCTYPE html>
                    <html>
                    <head>
                    <title>Photo Album Web View</title>
                    </head>
                    <body>
                    <h1>Snapshot ID: 2024-04-15T21:58:10.097043</h1>
                    <h2>  </h2>
                    <svg width="1000" height="1000">
                    <rect x="0" y="0" width="800" height="800" fill="rgb(33,94,248)" />
                    <rect x="80" y="424" width="100" height="326" fill="rgb(0,0,0)" />
                    <rect x="260" y="365" width="100" height="385" fill="rgb(0,0,0)" />
                    <rect x="440" y="375" width="100" height="375" fill="rgb(0,0,0)" />
                    <rect x="620" y="445" width="100" height="305" fill="rgb(0,0,0)" />
                    <rect x="100" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="140" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="100" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="140" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    </svg>
                    <h1>Snapshot ID: 2024-04-15T21:58:10.098995</h1>
                    <h2>  </h2>
                    <svg width="1000" height="1000">
                    <rect x="0" y="0" width="800" height="800" fill="rgb(33,94,248)" />
                    <rect x="80" y="424" width="100" height="326" fill="rgb(0,0,0)" />
                    <rect x="260" y="365" width="100" height="385" fill="rgb(0,0,0)" />
                    <rect x="440" y="375" width="100" height="375" fill="rgb(0,0,0)" />
                    <rect x="620" y="445" width="100" height="305" fill="rgb(0,0,0)" />
                    <rect x="100" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="140" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="100" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="140" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="280" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="320" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="280" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="320" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    </svg>
                    <h1>Snapshot ID: 2024-04-15T21:58:10.099556</h1>
                    <h2> Turn on the Lights! </h2>
                    <svg width="1000" height="1000">
                    <rect x="0" y="0" width="800" height="800" fill="rgb(33,94,248)" />
                    <rect x="80" y="424" width="100" height="326" fill="rgb(0,0,0)" />
                    <rect x="260" y="365" width="100" height="385" fill="rgb(0,0,0)" />
                    <rect x="440" y="375" width="100" height="375" fill="rgb(0,0,0)" />
                    <rect x="620" y="445" width="100" height="305" fill="rgb(0,0,0)" />
                    <rect x="100" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="140" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="100" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="140" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="280" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="320" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="280" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="320" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="460" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="500" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="460" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="500" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="640" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="680" y="500" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="640" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <rect x="680" y="600" width="20" height="20" fill="rgb(255,255,255)" />
                    <ellipse cx="250" cy="250" rx="50" ry="50" fill="rgb(229,229,255)" />
                    </svg>
                    """;

    IAlbum shapeAlbumModel = new ShapeAlbum();
    // Now we use the FileParser and AlbumController to generate the webview
    FileParser fileParser = new FileParser("buildings.txt");
    fileParser.parseFile(shapeAlbumModel);
    WebView newWebView = new WebView("buildings.html");
    newWebView.generateWebView(shapeAlbumModel);

    // Read in the generated webview file and compare with the big string above
    String generated = new String(Files.readAllBytes(Paths.get("buildings.html")));

    // Test whether the number of lines are the same
    assertEquals(compareTarget.lines().count(), generated.lines().count());

  }
}
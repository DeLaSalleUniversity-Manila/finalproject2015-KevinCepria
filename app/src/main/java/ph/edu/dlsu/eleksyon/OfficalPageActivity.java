package ph.edu.dlsu.eleksyon;

/**
 * Created by kevincepria on 12/8/2015.
 */
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
public class OfficalPageActivity extends Candidates {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halalan2016);
        WebView dlsu = (WebView) findViewById(R.id.webView);
        dlsu.getSettings().setLoadWithOverviewMode(true);
        dlsu.getSettings().setUseWideViewPort(true);
        dlsu.loadUrl("https://www.abs-cbnnews.com/halalan2016");

    }

}

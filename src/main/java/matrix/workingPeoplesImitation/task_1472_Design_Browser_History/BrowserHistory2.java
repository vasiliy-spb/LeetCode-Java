package matrix.workingPeoplesImitation.task_1472_Design_Browser_History;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me (Approach 1: Array)
public class BrowserHistory2 {
    public BrowserHistory2(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        if (++index < urls.size())
            urls.set(index, url);
        else
            urls.add(url);
        lastIndex = index;
    }

    public String back(int steps) {
        index = Math.max(0, index - steps);
        return urls.get(index);
    }

    public String forward(int steps) {
        index = Math.min(lastIndex, index + steps);
        return urls.get(index);
    }

    private List<String> urls = new ArrayList<>();
    private int index = -1;
    private int lastIndex = -1;
}

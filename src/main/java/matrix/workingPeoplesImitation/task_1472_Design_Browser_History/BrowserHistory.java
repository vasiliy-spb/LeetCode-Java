package matrix.workingPeoplesImitation.task_1472_Design_Browser_History;

// my solution
public class BrowserHistory {
    private Page home;

    public BrowserHistory(String homepage) {
        this.home = new Page(homepage, null);
    }

    public void visit(String url) {
        home.next = new Page(url, home);
        home = home.next;
    }

    public String back(int steps) {
        while (steps > 0 && home.parent != null) {
            home = home.parent;
            steps--;
        }
        return home.url;
    }

    public String forward(int steps) {
        while (steps > 0 && home.next != null) {
            home = home.next;
            steps--;
        }
        return home.url;
    }
    static class Page {
        String url;
        Page next;
        Page parent;
        public Page(String url, Page parent) {
            this.url = url;
            this.parent = parent;
        }
    }
}

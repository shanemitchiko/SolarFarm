package learn.solar.domain;

import learn.solar.models.Panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PanelResult {

    private ArrayList<String> messages = new ArrayList<>();
    private Panel payload;

    public Panel getPayload() {
        return payload;
    }

    public void setPayload(Panel payload) {
        this.payload = payload;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public boolean isSuccess() {
        return messages.size() == 0;
    }

    public void addErrorMessage(String message) {
        messages.add(message);
    }

    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        PanelResult that = (PanelResult) p;
        return Objects.equals(messages, that.messages) &&
                Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messages, payload);
    }
}


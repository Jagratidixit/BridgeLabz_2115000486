class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    TextState head, tail, current;
    int maxHistory = 10, size = 0;

    void addTextState(String content) {
        TextState newState = new TextState(content);
        if (current != null) {
            newState.prev = current;
            current.next = newState;
        }
        current = newState;
        if (head == null) head = newState;
        tail = newState;

        if (size == maxHistory) {
            head = head.next;
            head.prev = null;
        } else {
            size++;
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    void displayCurrentState() {
        System.out.println(current != null ? "Current State: " + current.content : "No text available.");
    }
}

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        
        editor.addTextState("Hello");
        editor.addTextState("Hello, Jagrati");
        editor.addTextState("Hello, Jagrati!");
        editor.displayCurrentState(); 

        editor.undo();
        editor.displayCurrentState(); 

        editor.undo();
        editor.displayCurrentState(); 

        editor.redo();
        editor.displayCurrentState(); 

        editor.addTextState("Hello, Universe!");
        editor.displayCurrentState();
        
        editor.undo();
        editor.displayCurrentState();
    }
}

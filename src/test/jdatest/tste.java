package test.jdatest;

public class tste {

    public class Event {
        // ... Other properties and methods of the Event class ...

        public MessageSend sendMessageEmbed() {
            // Assuming you have a method to create and send a message with an embedded content
            MessageSend messageSend = new MessageSend();
            // ... Code to set up the embedded content ...

            return messageSend;
        }
    }

    // Assuming you have a class named "MessageSend" to represent a message to be sent
    public class MessageSend {
        private ActionRow actionRow;

        public MessageSend setActionRow(ActionRow actionRow) {
            this.actionRow = actionRow;
            return this;
        }

        public void send() {
            // Assuming you have a method to send the message with the embedded content and action row
            // ... Code to send the message ...
        }
    }

    // Assuming you have a class named "ActionRow" to represent the action row content
    public class ActionRow {
        // ... Properties and methods related to the action row ...
    }

    // Example usage
    public class Main {
        public void main(String[] args) {
            Event event = new Event();
            // Create and set up the action row
            ActionRow actionRow = new ActionRow();
            // ... Code to set up the action row ...

            // Send the message with the embedded content and action row
            event.sendMessageEmbed().setActionRow(actionRow).send();
        }
    }
}

package tutorial;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

    public Bot() {
        super(System.getenv("BOT_TOKEN"));
    }

    @Override
    public String getBotUsername() {
        return "bpasynkovbot"; // имя бота из BotFather
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();

        System.out.println(user.getFirstName() + " написал " + msg.getText());
        /*if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();

            SendMessage message = new SendMessage(chatId, "Вы написали: " + text);
            try {
                execute(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

}

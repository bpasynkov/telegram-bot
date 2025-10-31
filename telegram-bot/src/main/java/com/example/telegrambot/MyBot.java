package com.example.telegrambot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyBot extends TelegramLongPollingBot {

    // Используем конструктор с DefaultBotOptions
    public MyBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotUsername() {
        return "YourBotUsername"; // имя бота из BotFather
    }

    @Override
    public String getBotToken() {
        return "YOUR_BOT_TOKEN"; // токен из BotFather
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();

            SendMessage message = new SendMessage(chatId, "Вы написали: " + text);
            try {
                execute(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        // Передаем новые DefaultBotOptions
        DefaultBotOptions options = new DefaultBotOptions();
        MyBot bot = new MyBot(options);

        botsApi.registerBot(bot);
    }
}

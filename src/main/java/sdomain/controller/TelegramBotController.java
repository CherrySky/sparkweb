package sdomain.controller;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import sdomain.services.telegram.ApiContextInitializer;
import sdomain.services.telegram.TelegramLongPollingBot;

public class TelegramBotController {

    public TelegramBotController() {
        init();
    }

    private void init() {
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new DonKwanBot());
            System.out.println("DonKwanBot started...");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    class DonKwanBot extends TelegramLongPollingBot {

        private static final String URL = "http://119.247.151.97:4567/wolf";

        @Override
        public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
            System.out.println("Update: " + update);
            if (update.hasMessage() && update.getMessage().hasText()) {
                SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                        .setChatId(update.getMessage().getChatId())
                        .setText(URL);
                try {
                    System.out.println("received: " + update.getMessage().getText());
                    sendMessage(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String getBotUsername() {
            return "donkwanbot";
        }

        @Override
        public String getBotToken() {
            return "343476350:AAFkh0-m2Icmtyl0me58sGdHHP9blKvAWA0";
        }

    }
}

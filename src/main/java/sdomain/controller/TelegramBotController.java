package sdomain.controller;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import sdomain.services.telegram.ApiContextInitializer;
import sdomain.services.telegram.TelegramLongPollingBot;

public class TelegramBotController {

    private static final String COMMAND_URL = "/url";

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

        private static final String URL = "http://18.218.10.89:4567/wolf";

        @Override
        public void onUpdateReceived(Update update) {
            System.out.println("Update: " + update);
            try {
                executeCommands(update);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        private void executeCommands(Update update) throws TelegramApiException {
            String text = update.getMessage().getText();
            SendMessage message = null;
            if (text != null && text.startsWith("/")) {
                if (text.startsWith(COMMAND_URL)) {
                    //if (update.hasMessage() && update.getMessage().hasText()) {
                    message = new SendMessage()
                            .setChatId(update.getMessage().getChatId())
                            .setText(URL);
                    sendMessage(message);
                    //}
                }

            } else {
//                message = new SendMessage()
//                        .setChatId(update.getMessage().getChatId())
//                        .setText("Chat is not allowed. Please use command start with /");
//                sendMessage(message);
            }
            System.out.println("Reply message: " + message);
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

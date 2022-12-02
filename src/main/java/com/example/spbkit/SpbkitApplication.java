package com.example.spbkit;

import org.springframework.boot.SpringApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class SpbkitApplication {
    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(SpbkitApplication.class, args);
        Bot bot  = new Bot();
        TelegramBotsApi telegramBot = new TelegramBotsApi(DefaultBotSession.class);
        telegramBot.registerBot(bot);

    }
}
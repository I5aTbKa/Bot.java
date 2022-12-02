package com.example.spbkit;


import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "SBPKIT216Bot";}
    @Override
    public String getBotToken() {
        return "5882057692:AAFCzxWU-jey1Zn2eL9dqHpUro2iGD5wUgE";}



    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Message command = update.getMessage();
            long chatId = update.getMessage().getChatId();

            switch (messageText){
                case "/start":
                    startAnswer(command);
                    break;
                case "/help":
                    helpanswer(command);
                    break;




                default:
                   error(command);
                   break;
            }
        }
        else if(update.hasCallbackQuery()){
            if(update.getCallbackQuery().getData().equals("start0")) {
                InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
                InlineKeyboardButton button1 = new InlineKeyboardButton();
                button1.setText("Курс 1");
                button1.setCallbackData("kurs1");

                InlineKeyboardButton button2 = new InlineKeyboardButton();
                button2.setText("Курс 2");
                button2.setCallbackData("kurs2");

                InlineKeyboardButton button3 = new InlineKeyboardButton();
                button3.setText("Курс 3");
                button3.setCallbackData("kurs3");

                InlineKeyboardButton button4 = new InlineKeyboardButton();
                button4.setText("Курс 4");
                button4.setCallbackData("kurs4");

                List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
                keyboardButtonsRow.add(button1);
                keyboardButtonsRow.add(button2);
                keyboardButtonsRow.add(button3);
                keyboardButtonsRow.add(button4);
                List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
                rowlist.add(keyboardButtonsRow);

                keyboard.setKeyboard(rowlist);

                
                try {
                    execute(
                            SendMessage
                                    .builder()
                                    .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                                    .parseMode("Markdown")
                                    .text("Введите курс:")
                                    .replyMarkup(keyboard)
                                    .build());

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                if (update.hasMessage() && "1".equals(update.getMessage().getText())){
                    String kurs;
                    kurs = update.getMessage().getText();
                    try {
                        execute(
                                SendMessage
                                        .builder()
                                        .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                                        .parseMode("Markdown")
                                        .text("Ваш курс"+kurs)
                                        .build());

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

                }
            }

        }


    private void sendwithoutURL(Message message){
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Узнать расписание");
        button.setCallbackData("start0");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(button);
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);

        keyboard.setKeyboard(rowlist);

        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(message.getChatId()))
                            .parseMode("Markdown")
                            .text("Здравствуйте")
                            .replyMarkup(keyboard)
                            .build());
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }


    }

    public void error(Message command){
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(command.getChatId()))
                            .parseMode("Markdown")
                            .text("Ошибка! Введите команду /help")
                            .build());
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }

    }

    public void startAnswer(Message command){
        sendwithoutURL(command);
    }
    public void helpanswer(Message message){
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(message.getChatId()))
                            .parseMode("Markdown")
                            .text("Чтобы начать работу введите '/start'")
                            .build());
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    public void kursi(Message message){
        Integer kurs;
        kurs = Integer.valueOf(message.getText());
        if(kurs==1){

        }
        else if(kurs==2){

        }
        else if(kurs==3){

        }
        else if(kurs==4){

        }
        else {
            try {
                execute(
                        SendMessage
                                .builder()
                                .chatId(String.valueOf(message.getChatId()))
                                .parseMode("Markdown")
                                .text("Ошибка, перепроверьте значения и повторите операцию")
                                .build());
            }
            catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }
}


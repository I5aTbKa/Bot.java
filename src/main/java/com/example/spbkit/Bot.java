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
        return "SBPKIT216Bot";
    }

    @Override
    public String getBotToken() {
        return "5882057692:AAFCzxWU-jey1Zn2eL9dqHpUro2iGD5wUgE";
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Message command = update.getMessage();

            switch (messageText) {
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
        } else if (update.hasCallbackQuery()) {
            Update perm = update;
            if (update.getCallbackQuery().getData().equals("start0")) {
                kurs(perm);
            }
            if (update.getCallbackQuery().getData().equals("back")) {
                back(perm);
            }


            if (update.getCallbackQuery().getData().equals("kurs1")) {
                kurs1(perm);
            } else if (update.getCallbackQuery().getData().equals("next1")) {
                kurs1_2(perm);
            } else if (update.getCallbackQuery().getData().equals("next1_1")) {
                kurs1_3(perm);
            }

            if (update.getCallbackQuery().getData().equals("kurs2")) {
                kurs2(perm);
            } else if (update.getCallbackQuery().getData().equals("next2")) {
                kurs2_2(perm);
            }
            if (update.getCallbackQuery().getData().equals("next2_1")) {
                kurs2_3(perm);
            }

            if (update.getCallbackQuery().getData().equals("kurs3")) {
                kurs3(perm);
            } else if (update.getCallbackQuery().getData().equals("next3")) {
                kurs3_2(perm);
            }
            if (update.getCallbackQuery().getData().equals("next3_1")) {
                kurs3_3(perm);
            }

            if (update.getCallbackQuery().getData().equals("kurs4")) {
                kurs4(perm);
            } else if (update.getCallbackQuery().getData().equals("next4")) {
                kurs4_2(perm);
            }


            if (update.getCallbackQuery().getData().equals("group121")) {
                day(perm);
            }

        }
    }


    private void sendwithoutURL(Message message) {
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
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

    public void error(Message command) {
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(command.getChatId()))
                            .parseMode("Markdown")
                            .text("Ошибка! Введите команду /help")
                            .build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void startAnswer(Message command) {
        sendwithoutURL(command);
    }


    public void helpanswer(Message message) {
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(message.getChatId()))
                            .parseMode("Markdown")
                            .text("Чтобы начать работу введите '/start'")
                            .build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void back(Update update) {
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
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Здравствуйте")
                            .replyMarkup(keyboard)
                            .build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void kurs(Update update) {
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

        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText("Назад");
        button5.setCallbackData("back");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(button5);
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
                            .text("Выберите курс:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void kurs1(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("121");
        button1.setCallbackData("group121");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("122");
        button2.setCallbackData("group122");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("123");
        button3.setCallbackData("group123");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("Вперёд");
        next.setCallbackData("next1");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);
        keyboardButtonsRow.add(next);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите группу:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs1_2(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("124");
        button1.setCallbackData("group124");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("125");
        button2.setCallbackData("group125");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("126");
        button3.setCallbackData("group126");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("Вперёд");
        next.setCallbackData("next1_1");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);
        keyboardButtonsRow.add(next);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs1_3(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("127");
        button1.setCallbackData("group127");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("21");
        button2.setCallbackData("group21");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("22");
        button3.setCallbackData("group22");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");


        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs2(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("211");
        button1.setCallbackData("group211");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("212");
        button2.setCallbackData("group212");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("213");
        button3.setCallbackData("group213");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("Вперёд");
        next.setCallbackData("next2");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);
        keyboardButtonsRow.add(next);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs2_2(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("214");
        button1.setCallbackData("group214");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("215");
        button2.setCallbackData("group215");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("216");
        button3.setCallbackData("group216");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("Вперёд");
        next.setCallbackData("next2_1");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);
        keyboardButtonsRow.add(next);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs2_3(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("11");
        button1.setCallbackData("group11");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("12");
        button2.setCallbackData("group12");


        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");


        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);


        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs3(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("301");
        button1.setCallbackData("group301");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("302");
        button2.setCallbackData("group302");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("303");
        button3.setCallbackData("group303");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("Вперёд");
        next.setCallbackData("next3");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);
        keyboardButtonsRow.add(next);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs3_2(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("304");
        button1.setCallbackData("group304");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("305");
        button2.setCallbackData("group305");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("306");
        button3.setCallbackData("group306");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("Вперёд");
        next.setCallbackData("next3_1");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);
        keyboardButtonsRow.add(next);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs3_3(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("01");
        button1.setCallbackData("group01");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("02");
        button2.setCallbackData("group02");


        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");


        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);


        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs4(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("491");
        button1.setCallbackData("group491");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("492");
        button2.setCallbackData("group492");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("493");
        button3.setCallbackData("group493");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("Вперёд");
        next.setCallbackData("next4");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);
        keyboardButtonsRow.add(next);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void kurs4_2(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("494");
        button1.setCallbackData("group494");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("495");
        button2.setCallbackData("group495");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("496");
        button3.setCallbackData("group496");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");


        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);


        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите group:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void day(Update update) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Понедельник");
        button1.setCallbackData("Monday");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Вторник");
        button2.setCallbackData("Thuesday");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("Среда");
        button3.setCallbackData("Wednesday");

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton next = new InlineKeyboardButton();
        back.setText("Вперёд");
        back.setCallbackData("next_day");


        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(back);
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);
        keyboardButtonsRow.add(next);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        keyboard.setKeyboard(rowlist);
        try {
            execute(
                    SendMessage
                            .builder()
                            .chatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()))
                            .parseMode("Markdown")
                            .text("Выберите день:")
                            .replyMarkup(keyboard)
                            .build());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}





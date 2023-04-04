package tgBotClasses;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.request.SetMyCommands;

public class TgBot {
    TelegramBot bot = new TelegramBot("6228063170:AAEEagP7ZAvEG44Bwb-j0LdQBRVPVeSXNsM");
    public void startBot(){
        TgBotMethods tgBotMethods = new TgBotMethods();
        tgBotMethods.setBot(bot);
        tgBotMethods.setUpdateListener();

        BotCommand[] botCommands = {new BotCommand("help","Вывести окно с командами"),
                new BotCommand("track","Начать отслеживание ссылки"),
                new BotCommand("untrack", "Прекратить отслеживание ссылки"),
                new BotCommand("list", "Показать список отслеживаемых ссылок")};
        bot.execute(new SetMyCommands(botCommands));

    }
}


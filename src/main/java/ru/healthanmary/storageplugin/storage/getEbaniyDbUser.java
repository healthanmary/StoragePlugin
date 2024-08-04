package ru.healthanmary.storageplugin.storage;

import lombok.AllArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ru.healthanmary.storageplugin.User;

@AllArgsConstructor
public class getEbaniyDbUser implements CommandExecutor {
    private final Storage storage;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) return false;
        final String name = args[0];

        User user = storage.getUser(name);
        if (user == null) {
            sender.sendMessage("Нема");
            return true; }
        sender.sendMessage(user.getName() + " " + user.getAge());
        return true;
    }
}

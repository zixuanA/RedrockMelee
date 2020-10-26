package framework;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

class PlayerGenerator {
    private static final String PLAYER_FILE_PATH = "src/players";
    private static final String PACKAGE_NAME_PREFIX = "players.";

    public ArrayList<AbstractPlayer> generate() {
        ArrayList<AbstractPlayer> players = new ArrayList<>();
        File playerFile = new File(PLAYER_FILE_PATH);
        for (File file : Objects.requireNonNull(playerFile.listFiles())) {
            if (file.getName().contains(".java")) {
                String className = file.getName().replace(".java", "");
                try {
                    Class<? extends AbstractPlayer> clazz = (Class<? extends AbstractPlayer>) Class.forName(PACKAGE_NAME_PREFIX + className);
                    players.add(clazz.newInstance());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return players;
    }
}

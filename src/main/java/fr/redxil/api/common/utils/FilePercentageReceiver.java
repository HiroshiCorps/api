package fr.redxil.api.common.utils;

public interface FilePercentageReceiver {
    void changePercentage(double percent);

    void noPercentage();

    void fileSize(int size);

    void sendInfo(String data);
}

package fr.redxil.api.common.player.data;

public interface LinkData {

    int getLinkID();

    long getPlayerSender();

    long getPlayerReceiver();

    String getLinkType();

    LinkUsage getLinkUsage();

    void deleteLink();

}

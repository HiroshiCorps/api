package fr.redxil.api.common.player.data;

public interface LinkData {

    int getLinkID();

    long getFromPlayer();

    long getToPlayer();

    String getLinkType();

    void setLinkType(String linkType);

    void deleteLink();

}

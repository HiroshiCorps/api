/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.group.party;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface Party {

    /**
     * Permet de rejoindre la partie d'un joueur
     *
     * @param apiPlayer UUID du joueur
     * @return Validation de l'action
     */
    boolean joinParty(UUID apiPlayer);

    /**
     * Permet de quitter la partie dans la quelle se trouve le joueur
     *
     * @param apiPlayer UUID du joueur
     * @return Validation de l'action
     */
    boolean quitParty(UUID apiPlayer);

    /**
     * Permet de kick un joueur si la partie appartient au joueur
     *
     * @param kicker    UUID du joueur qui tiens la partie
     * @param apiPlayer UUID du joueur qui se fait kick
     * @return Validation de l'action
     */
    boolean kickParty(UUID kicker, UUID apiPlayer);

    /**
     * change le rank d'un des joueurs de la partie
     *
     * @param target    UUID du joueur qui se fait up rank
     * @param partyRank Choix du rank en question
     * @return Validation de l'action
     */
    boolean setPartyRank(UUID target, PartyRank partyRank);

    /**
     * @param apiPlayer UUID du joueur
     * @return Retourne le rank du joueur apiPlayer
     */
    PartyRank getPartyRank(UUID apiPlayer);

    /**
     * @return etat de la partie ( si elle est ouverte, fermé, ou avec invitation)
     */
    PartyAccess getPartyAccess();

    /**
     * @param partyAccess permet de changer l'etat de la partie
     */
    void setPartyAccess(PartyAccess partyAccess);

    /**
     * @param apiPlayer UUID du joueur
     * @return verifie si le joueur est owner de la partie.
     */
    boolean isPartyOwner(UUID apiPlayer);

    boolean hisInParty(UUID apiPlayer);

    List<UUID> getPlayerList();

    boolean deleteParty(UUID author);

    long getPartyID();

    boolean invitePlayer(UUID apiPlayer);

    boolean revokeInvite(UUID apiPlayer);

    boolean hisInvitePlayer(UUID apiPlayer);

    UUID getPartyOwner();

    Map<UUID, PartyRank> getRank();

}

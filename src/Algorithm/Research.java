package  Algorithm;

import Database.Mappers.FriendshipMapper;
import Database.Mappers.MemberMapper;
import Entity.Like;
import Entity.Member;

import java.sql.SQLException;
import java.util.*;

public class Research {
    public void suggestionFriendShortestPath(Member member) throws SQLException {
        ArrayList<Member> listFriends = new ArrayList<Member>();
        FriendshipMapper friendship = new FriendshipMapper();
        try {
            listFriends = friendship.findFriends(member);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (int i = 0; i <listFriends.size(); i++) {
            ArrayList<Member> listFriendsOfFriend = friendship.findFriends(listFriends.get(i));
            for (int j = 0; j < listFriendsOfFriend.size(); j++) {
                if (notInclude(listFriendsOfFriend.get(j), listFriends)) {
                    System.out.print(listFriendsOfFriend.get(j).getNameUser());
                }
            }
        }
    }

    private boolean notInclude(Member member, ArrayList<Member> listFriend) {
        for (int i = 0; i < listFriend.size(); i++) {
            if (member.equals(listFriend.get(i)))
                return false;
        }
        return true;
    }

    public void suggestionFriendCommun(Member member) throws SQLException {
        ArrayList<Member> listFriends = new ArrayList<Member>();
        FriendshipMapper friendship = new FriendshipMapper();
        listFriends = friendship.findFriends(member);
        HashMap<Member, Integer> sugguedFriend = new HashMap<Member, Integer>();
        for (int i = 0; i < listFriends.size(); i++) {
            ArrayList<Member> listFriendsOfFriend = friendship.findFriends(listFriends.get(i));
            for (int j = 0; j < listFriendsOfFriend.size(); j++) {
                if (sugguedFriend.containsKey(listFriendsOfFriend.get(j))) {
                    int value = sugguedFriend.get(listFriendsOfFriend.get(j));
                    sugguedFriend.put(listFriendsOfFriend.get(j), value + 1);
                }
                else {
                    sugguedFriend.put(listFriendsOfFriend.get(j), 1);
                }
            }
           // List<> suggestion = new ArrayList<>(sugguedFriend.keySet());
            //Collections.sort(suggestion);
            //SortedSet<Member> keySet = new TreeSet<>(sugguedFriend.keySet());
            //trier(listFriendsOfFriend);
        }
    }

    public void SuggestionPageCommun(Member member) throws SQLException {
        ArrayList<Integer> listPage = new ArrayList<Integer>();
        Like page = new Like();
        listPage = (ArrayList<Integer>) page.listLikerPage(member.getId());
        HashMap<Integer, Integer> sugguedFriend = new HashMap<Integer, Integer>();
        for (int i = 0;i<listPage.size(); i++){
            ArrayList<Integer> listFollowerPage = (ArrayList<Integer>) page.listMemberPage(listPage.get(i));
            for(int j = 0; j<listFollowerPage.size();j++){
                if (sugguedFriend.containsKey(listFollowerPage.get(j))) {
                    int value = sugguedFriend.get(listFollowerPage.get(j));
                    sugguedFriend.put(listFollowerPage.get(j), value + 1);
                }
                else {
                    sugguedFriend.put(listFollowerPage.get(j), 1);
                }
            }
        }
    }
    public Member ResearchMember(Member member , String name) throws SQLException {
        ArrayList<Member> fileMember = new ArrayList<>();
        FriendshipMapper mapper = new FriendshipMapper();
        MemberMapper mapperMembre = new MemberMapper();
        int lastIdMember = mapperMembre.nbreUtilisateurs();
        int positionInFile = 0;
        fileMember.add(member);
        Member actualMember = member;
        while (actualMember.getNameUser()!=name && actualMember.getId()==lastIdMember){
            ArrayList<Member> listFriend = mapper.findFriends(actualMember);
            int friendAdded = 0;
            for(Member m: listFriend){
                if(notInclude(m,fileMember)){
                    fileMember.add(m);
                    friendAdded ++;
                }
            }
            if (friendAdded == 0 && actualMember == fileMember.get(fileMember.size() - 1)){
                fileMember.add(researchMemberNotInclude(fileMember));
            }
            positionInFile = positionInFile + 1;
            actualMember = fileMember.get(positionInFile);

        }
        if(actualMember.getNameUser() == name){
            return actualMember;
        }
        else {
            return new Member() ;
        }
    }

    public Member researchMemberNotInclude(ArrayList<Member>fileMember){
        ArrayList<Integer> id = new ArrayList<Integer>();
        MemberMapper mapper = new MemberMapper();
        for(Member m: fileMember){
            id.add(m.getId());
        }
        Collections.sort(id);
        for(int i = 0; i < id.size() ; i++){
            if(i!= id.get(i)){
                return mapper.findById(i);
            }
        }
        return mapper.findById(id.size()) ;
    }
}
package programmers;

import java.util.HashSet;
import java.util.Set;

public class SkillTrees {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {
                "BACDE",
                "CBADF",
                "AECB",
                "BDA"
        };

        int answer = solution(skill, skill_trees);

        System.out.println(answer);
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int skillIdx =0;

        Set<Character> set = new HashSet<>();

        for (int i=0; i<skill.length(); i++) {
            set.add(skill.charAt(i));
        }

        for (int i=0; i<skill_trees.length; i++) {
            for (int j=0; j<skill_trees[i].length(); j++) {
                Character sk = skill_trees[i].charAt(j);
                if (set.contains(sk)) {
                    if (sk == skill.charAt(skillIdx)) {
                        skillIdx++;
                    } else {
                        break;
                    }
                }

                if (j == skill_trees[i].length()-1) answer++;
            }
            skillIdx = 0;
        }

        return answer;
    }
}

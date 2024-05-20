package com.example.estarepository.activity.service;

import com.example.estarepository.activity.Activity;
import com.example.estarepository.activity.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public List<Activity> findAll(String text, String sortBy, Sort.Direction sortDirection, int from, int size) {
        var pageNumber = (from + 1) / size;
        PageRequest pageRequest = PageRequest.of(pageNumber, size, Sort.by(sortDirection, sortBy));

        return activityRepository.findAllActivities(text, pageRequest).toList();
    }

    public void mock() {
        var count = 10000;

        for (var i = 0; i < count; i++) {
            var activity = Activity.builder()
                    .title(titles[Utils.getNumber(0, titles.length)])
                    .fileName(fileNames[Utils.getNumber(0, fileNames.length)])
                    .usageCounter(Utils.getNumber(0, 100))
                    .createdOn(
                            Utils.getDate(LocalDate.now().minusYears(10), LocalDate.now()).atStartOfDay(ZoneId.systemDefault()).toInstant()
                    )
                    .keywords(new ArrayList<>())
                    .build();

            var keywordsCount = Utils.getNumber(0, 5);

            for (var j = 0; i < keywordsCount; j++) {
                var keyword = keywords[Utils.getNumber(0, keywords.length)];
                activity.getKeywords().add(keyword);
            }

            this.activityRepository.saveAndFlush(activity);
        }
    }

    private static String[] titles = {
            "Articulation Practice",
            "Phonological Awareness Games",
            "Vocabulary Building",
            "Storytelling Sessions",
            "Conversation Starters",
            "Reading Comprehension",
            "Social Skills Training",
            "Auditory Processing Exercises",
            "Pronunciation Drills",
            "Language Development Activities"
    };

    private static String[] keywords = {
            "speech sounds", "clarity", "phonemes", "repetition", "mouth exercises",
            "rhyming", "syllables", "phonics", "sound matching", "blending",
            "word lists", "definitions", "synonyms", "antonyms", "context",
            "narrative skills", "imagination", "sequencing", "expressive language", "creativity",
            "icebreakers", "topics", "discussion", "interaction", "engagement",
            "reading skills", "understanding", "interpretation", "questioning", "critical thinking",
            "empathy", "body language", "role-playing", "turn-taking", "peer interaction",
            "listening skills", "sound discrimination", "auditory memory", "attention", "processing",
            "accent reduction", "intonation", "stress patterns", "fluency", "articulation",
            "grammar", "sentence structure", "language rules", "communication", "development"
    };

    private static String[] fileNames = {
            "17081011859051708101185905_1.5MB - Copy.pdf",
            "17081015021711708101502171_1.5MB.pdf",
            "1708101684871_1.5MB.pdf",
            "1708116383618_1.5MB - Copy.pdf",
            "1708167177587_1.5MB.pdf",
            "1709496282830_1.5MB - Copy.pdf",
            "1711392879579_1.5MB.pdf",
            "1711392918356_1.5MB - Copy.pdf",
            "1711473128693_1.5MB.pdf",
            "1711483819219_1.5MB - Copy.pdf",
            "1711549633367_Renowned true or false.pdf",
            "1712682912940_1.5MB.pdf",
            "1712747665471_1.5MB.pdf",
            "1712758370727_1.5MB - Copy.pdf",
            "1712828194636_1.5MB - Copy.pdf",
            "1712854257975_1.5MB - Copy.pdf",
            "1712919523805_1.5MB.pdf",
            "1713553500084_ESTA update Design Thinking 4.pdf",
            "1713559522541_1712828194636_1.5MB - Copy.pdf",
            "1713625740497_1712828194636_1.5MB - Copy.pdf",
            "1713625761150_label (1).pdf",
            "1713705030105_1708101684871_1.5MB (4).pdf",
            "1713780283915_Renowned true false.pdf",
            "1713860595155_Final+R+Picture+Cards-material_18700270.pdf",
            "1713861202613_Final+R+Picture+Cards-material_18700270.pdf",
            "1713867499933_ist-ekb - Copy.pdf",
            "1713867639695_1.5MB - Copy.pdf",
            "1713877338148_Final+R+Picture+Cards-material_18700270.pdf",
            "1713881500581_EngageSLT_IOP_APP Walk Through.pdf",
            "1713975056577_1.5MB - Copy.pdf",
            "1715762358388_Multi.pdf",
            "1715769254370_Listening_to_and_following_instructions.pdf",
            "1715770017674_Little Red Riding Hood Story.pdf",
            "1715844451043_minimal pair bingo k+t WIP.pdf",
            "1715849271441_02-Modelling-and-Recasting.pdf",
            "7_1708337029868_sample-research-proposal.pdf"
    };


    class Utils {
        public static String getWord(int length) {
            var result = "";
            var characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            var charactersLength = characters.length();

            var counter = 0;

            while (counter < length) {
                result += characters.charAt(getNumber(0, charactersLength));
                counter++;
            }
            return result;
        }

        public static int getNumber(int min, int max) {
            return (int) ((Math.random() * (max - min)) + min);
        }

        public static LocalDate getDate(LocalDate startInclusive, LocalDate endExclusive) {
            long startEpochDay = startInclusive.toEpochDay();
            long endEpochDay = endExclusive.toEpochDay();
            long randomDay = ThreadLocalRandom
                    .current()
                    .nextLong(startEpochDay, endEpochDay);
            return LocalDate.ofEpochDay(randomDay);
        }
    }

}

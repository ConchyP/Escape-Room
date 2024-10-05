package dev.conchy.escape_room.profile;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

   
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

   
    public Profile getByUserId(Long userId) {
        Optional<Profile> profileOptional = profileRepository.findById(userId);
       
        return profileOptional.orElse(null); 
    }
}

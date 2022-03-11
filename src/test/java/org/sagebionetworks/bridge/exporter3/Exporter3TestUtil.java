package org.sagebionetworks.bridge.exporter3;

import org.sagebionetworks.bridge.rest.model.App;
import org.sagebionetworks.bridge.rest.model.Exporter3Configuration;
import org.sagebionetworks.bridge.rest.model.Study;
import org.sagebionetworks.bridge.rest.model.StudyPhase;

public class Exporter3TestUtil {
    public static final String APP_ID = "test-app";
    public static final long DATA_ACCESS_TEAM_ID = 1111L;
    public static final String PROJECT_ID = "syn4444";
    public static final String PARTICIPANT_VERSION_TABLE_ID = "syn4999";
    public static final String RAW_FOLDER_ID = "syn5555";
    public static final long STORAGE_LOCATION_ID = 6666L;
    public static final String STUDY_ID = "test-study";

    public static App makeAppWithEx3Config() {
        App app = new App();
        app.setIdentifier(APP_ID);
        app.setExporter3Enabled(true);
        app.setExporter3Configuration(makeEx3Config());
        return app;
    }

    public static Study makeStudyWithEx3Config() {
        Study study = new Study();
        study.setIdentifier(STUDY_ID);
        study.setExporter3Enabled(true);
        study.setExporter3Configuration(makeEx3Config());
        study.setPhase(StudyPhase.RECRUITMENT);
        return study;
    }

    public static Exporter3Configuration makeEx3Config() {
        Exporter3Configuration ex3Config = new Exporter3Configuration();
        ex3Config.setDataAccessTeamId(DATA_ACCESS_TEAM_ID);
        ex3Config.setProjectId(PROJECT_ID);
        ex3Config.setParticipantVersionTableId(PARTICIPANT_VERSION_TABLE_ID);
        ex3Config.setRawDataFolderId(RAW_FOLDER_ID);
        ex3Config.setStorageLocationId(STORAGE_LOCATION_ID);

        // Need to set isConfigured manually. Normally, this is auto-generated by the server, but there is no server in
        // mock tests.
        ex3Config.setConfigured(true);

        return ex3Config;
    }
}

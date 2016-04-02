/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.common.infotech;

/**
 * com.akam.infotech.ITJob
 * <p/>
 * IT Job Roles and Responsibilities Explained
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version February 26, 2016
 * @see <a href="https://targetpostgrad.com/subjects/computer-science-and-it/it-job-roles-and-responsibilities-explained" />
 * @since 1.8
 */

public enum ITJobRole {

    SOFTWARE_ENGINEER("Application programmer, software architect, system programmer/engineer; Analysis, logical thinking, teamwork and attention to detail."),
    SYSTEM_ANALYST("Product specialist, systems engineer, solutions specialist, technical designer; Ability to extract and analyse information, good communication, persuasion and sensitivity."),
    BUSINESS_ANALYST("Business architect, enterprise-wide information specialist; Communication, presentation, facilitation, project management and problem solving."),
    TECHNICAL_SUPPORT("Helpdesk support, operations analyst, problem manager; Wide ranging tech knowledge, problem solving, communication/listening, patience and diplomacy."),
    NETWORK_ENGINEER("Hardware engineer, network designer; Specialist network knowledge, communication, planning, analysis and problem solving."),
    TECHNICAL_CONSULTANT("IT consultant, application specialist, enterprise-wide information specialist; Communication, presentation, technical and business understanding, project management and teamwork."),
    TECHNICAL_SALES("Sales manager, account manager, sales executive; Product knowledge, persuasion, interpersonal skills, drive, mobility and business awareness."),
    PROJECT_MANAGER("Product planner, project leader, master scheduler; Organisation, problem solving, communication, clear thinking, and the ability to stay calm under pressure."),
    WEB_DEVELOPER("Web designer, web producer, multimedia architect, internet engineer; Basic understanding of web technologies (client side, server side and databases), analytical thinking, problem solving and creativity."),
    SOFTWARE_TESTER("Test analyst, software quality assurance tester; Attention to detail, creativity, organisation, analytical and investigative thinking, and communication.");

    private String jobRole;

    ITJobRole(final String jobRole) {
        this.jobRole = jobRole;
    }

    public String getValue() {
        return jobRole;
    }

    @Override
    public String toString() {
        return getValue();
    }
}

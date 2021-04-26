% Forced Deadlock - Manipulate Timing and State

weakness(forced_deadlock, 'Unrestricted Externally Accessible Lock').
weakness(forced_deadlock, 'Unsynchronized Access to Shared Data in a Multithreaded Context').
weakness(forced_deadlock, 'Improper Synchronization').
weakness(forced_deadlock, 'Improper Locking').
weakness(forced_deadlock, 'Deadlock').
weakness(forced_deadlock, 'Use of Blocking Code in Single-threaded, Non-blocking Context').

mitigation(forced_deadlock, 'Use known algorithm to avoid deadlock condition (for instance non-blocking synchronization algorithms).').
mitigation(forced_deadlock, 'For competing actions, use well-known libraries which implement synchronization.').

domain_of_attack(forced_deadlock, 'Software').

attack(forced_deadlock, 'Denial of service', 51).

% Leveraging Race Conditions - Manipulate Timing and State

weakness(leveraging_race_conditions, 'Context Switching Race Condition').
weakness(leveraging_race_conditions, 'Race Condition Enabling Link Following').
weakness(leveraging_race_conditions, 'Race Condition within a Thread').
weakness(leveraging_race_conditions, 'Missing Check for Certificate Revocation after Initial Check').
weakness(leveraging_race_conditions, 'Concurrent Execution using Shared Resource with Improper Synchronization (Race Condition)').
weakness(leveraging_race_conditions, 'Improper Synchronization').
weakness(leveraging_race_conditions, 'Permission Race Condition During Resource Copy').
weakness(leveraging_race_conditions, 'Improper Locking').
weakness(leveraging_race_conditions, 'Improper Initialization').
weakness(leveraging_race_conditions, 'Race Condition for Write-Once Attributes').

mitigation(leveraging_race_conditions, 'Use safe libraries to access resources such as files.').
mitigation(leveraging_race_conditions, 'Be aware that improper use of access function calls such as chown(), tempfile(), chmod(), etc. can cause a race condition.').
mitigation(leveraging_race_conditions, 'Use synchronization to control the flow of execution.').
mitigation(leveraging_race_conditions, 'Use static analysis tools to find race conditions.').
mitigation(leveraging_race_conditions, 'Pay attention to concurrency problems related to the access of resources.').

domain_of_attack(leveraging_race_conditions, 'Software').
domain_of_attack(leveraging_race_conditions, 'Hardware').

parent_of(leveraging_race_conditions, 'Leveraging Time-of-Check and Time-of-Use (TOCTOU) Race Conditions').

attack(leveraging_race_conditions, 'Race condition', 67).

% Manipulating State - Manipulate Timing and State

weakness(manipulating_state, 'Incomplete Internal State Distinction').
weakness(manipulating_state, 'State Issues').
weakness(manipulating_state, 'Cleartext Storage of Sensitive Information in a Cookie').
weakness(manipulating_state, 'Missing Support for Integrity Check').
weakness(manipulating_state, 'Protection Mechanism Failure').
weakness(manipulating_state, 'Improper Finite State Machines (FSMs) in Hardware Logic').
weakness(manipulating_state, 'Unintended Reentrant Invocation of Non-reentrant Code Via Nested Calls').
weakness(manipulating_state, 'Unitialized Value on Reset for Registers Holding Security Settings').

mitigation(manipulating_state, 'Do not rely solely on user-controllable locations, such as cookies or URL parameters, to maintain user state.').
mitigation(manipulating_state, 'Avoid sensitive information, such as usernames or authentication and authorization information, in user-controllable locations.').
mitigation(manipulating_state, 'Sensitive information that is part of the user state must be appropriately protected to ensure confidentiality and integrity at each request.').
mitigation(manipulating_state, 'All possible states must be handled by hardware finite state machines.').

domain_of_attack(manipulating_state, 'Software').
domain_of_attack(manipulating_state, 'Hardware').

parent_of(manipulating_state, 'Bypassing of Intermediate Forms in Multiple-Form Sets').

attack(manipulating_state, 'State information modification maintained by the target software', 43).
attack(manipulating_state, 'State transition in hardware', 23).
attack(manipulating_state, 'Denial of service', 31).
attack(manipulating_state, 'Exposure of secure data', 27).

% Interface Manipulation - Abuse Existing Functionality

weakness(interface_manipulation, '7PK - API Abuse').
weakness(interface_manipulation, 'System-on-Chip (SoC) Using Components without Unique, Immutable Identifiers').

mitigation(interface_manipulation, 'Mitigation for this attack is currently not available.').

domain_of_attack(interface_manipulation, 'Software').
domain_of_attack(interface_manipulation, 'Hardware').

parent_of(interface_manipulation, 'Using Unpublished Interfaces').
parent_of(interface_manipulation, 'Exploit Non-Production Interfaces').
parent_of(interface_manipulation, 'Try All Common Switches').
parent_of(interface_manipulation, 'Exploit Script-Based APIs').

attack(interface_manipulation, 'Bypassing access control and/or executing functionality not intended by the interface implementation', 73).
attack(interface_manipulation, 'Forcing the unexpected use of an interface', 53).
attack(interface_manipulation, 'Using an interface in an unintended way', 59).

% Flooding - Abuse Existing Functionality

weakness(flooding, 'Improper Resource Shutdown or Release').
weakness(flooding, 'Allocation of Resources Without Limits or Throttling').

mitigation(flooding, 'Ensure that protocols have specific limits of scale configured.').
mitigation(flooding, 'Specify expectations for capabilities and dictate which behaviors are acceptable when resource allocation reaches limits.').
mitigation(flooding, 'Uniformly throttle all requests in order to make it more difficult to consume resources more quickly than they can again be freed.').

domain_of_attack(flooding, 'Software').
domain_of_attack(flooding, 'Communications').

parent_of(flooding, 'TCP Flood').
parent_of(flooding, 'UDP Flood').
parent_of(flooding, 'ICMP Flood').
parent_of(flooding, 'HTTP Flood').
parent_of(flooding, 'SSL Flood').
parent_of(flooding, 'Amplification').
parent_of(flooding, 'XML Flood').

attack(flooding, 'Prevents legitimate users from accessing the service and can cause the target to crash', 52).

% Excessive Allocation - Abuse Existing Functionality

weakness(excessive_allocation, 'Improper Resource Shutdown or Release').
weakness(excessive_allocation, 'Allocation of Resources Without Limits or Throttling').
weakness(excessive_allocation, 'Improperly Controlled Sequential Memory Allocation').

mitigation(excessive_allocation, 'Limit the amount of resources that are accessible to unprivileged users.').
mitigation(excessive_allocation, 'Assume all input is malicious. Consider all potentially relevant properties when validating input.').
mitigation(excessive_allocation, 'Consider uniformly throttling all requests in order to make it more difficult to consume resources more quickly than they can again be freed.').
mitigation(excessive_allocation, 'Use resource-limiting settings, if possible.').

domain_of_attack(excessive_allocation, 'Software').
domain_of_attack(excessive_allocation, 'Communications').

parent_of(excessive_allocation, 'XML Nested Payloads').
parent_of(excessive_allocation, 'Oversized Serialized Data Payloads').
parent_of(excessive_allocation, 'Regular Expression Exponential Blowup').
parent_of(excessive_allocation, 'SOAP Array Blowup').
parent_of(excessive_allocation, 'TCP Fragmentation').
parent_of(excessive_allocation, 'UDP Fragmentation').
parent_of(excessive_allocation, 'ICMP Fragmentation').

attack(excessive_allocation, 'Reducing the resources available for legitimate services and degrading or denying services', 46).
attack(excessive_allocation, 'Cause the target to allocate resources vastly beyond what would be needed for a normal request', 49).

% Resource Leak Exposure - Abuse Existing Functionality

weakness(resource_leak_exposure, 'Improper Resource Shutdown or Release').

mitigation(resource_leak_exposure, 'If possible, leverage coding language(s) that do not allow this weakness to occur (e.g., Java, Ruby, and Python all perform automatic garbage collection that releases memory for objects that have been deallocated).').
mitigation(resource_leak_exposure, 'Memory should always be allocated/freed using matching functions (e.g., malloc/free, new/delete, etc.)').
mitigation(resource_leak_exposure, 'Implement best practices with respect to memory management, including the freeing of all allocated resources at all exit points and ensuring consistency with how and where memory is freed in a function.').

domain_of_attack(resource_leak_exposure, 'Software').

attack(resource_leak_exposure, 'Deplete the quantity of the resource available to service legitimate requests', 77).

% Functionality Misuse - Abuse Existing Functionality

weakness(functionality_misuse, 'Inclusion of Undocumented Features or Chicken Bits').
weakness(functionality_misuse, 'Sequence of Processor Instructions Leads to Unexpected Behavior (Halt and Catch Fire)').

mitigation(functionality_misuse, 'Perform comprehensive threat modeling, a process of identifying, evaluating, and mitigating potential threats to the application. This effort can help reveal potentially obscure application functionality that can be manipulated for malicious purposes.').
mitigation(functionality_misuse, 'When implementing security features, consider how they can be misused and compromised.').

domain_of_attack(functionality_misuse, 'Software').
domain_of_attack(functionality_misuse, 'Hardware').

parent_of(functionality_misuse, 'Inducing Account Lockout').
parent_of(functionality_misuse, 'Passing Local Filenames to Functions That Expect a URL').
parent_of(functionality_misuse, 'Password Recovery Exploitation').
parent_of(functionality_misuse, 'JSON Hijacking (aka JavaScript Hijacking)').
parent_of(functionality_misuse, 'Drop Encryption Level').

attack(functionality_misuse, 'Negative technical impact', 65).
attack(functionality_misuse, 'Access to unauthorized, sensitive data', 38).

% Communication Channel Manipulation - Abuse Existing Functionality

mitigation(communication_channel_manipulation, 'Encrypt all sensitive communications using properly-configured cryptography.').
mitigation(communication_channel_manipulation, 'Design the communication system such that it associates proper authentication/authorization with each channel/message.').

domain_of_attack(communication_channel_manipulation, 'Communications').

parent_of(communication_channel_manipulation, 'Choosing Message Identifier').
parent_of(communication_channel_manipulation, 'Exploiting Incorrectly Configured SSL').

attack(communication_channel_manipulation, 'Information exposure', 78).
attack(communication_channel_manipulation, 'Insertion/removal of information from the communications stream', 56).
attack(communication_channel_manipulation, 'Potential system compromise', 45).

% Sustained Client Engagement - Abuse Existing Functionality

mitigation(sustained_client_engagement, 'Potential mitigations include requiring a unique login for each resource request, constraining local unprivileged access by disallowing simultaneous engagements of the resource, or limiting access to the resource to one access per IP address. In such scenarios, the adversary would have to increase engagements either by launching multiple sessions manually or programmatically to counter such defenses.').

domain_of_attack(sustained_client_engagement, 'Software').

parent_of(sustained_client_engagement, 'HTTP DoS').

attack(sustained_client_engagement, 'Legitimate users are limited or completely denied access to the resource', 76).

% Protocol Manipulation - Abuse Existing Functionality

mitigation(protocol_manipulation, 'Mitigation for this attack is currently not available.').

domain_of_attack(protocol_manipulation, 'Software').
domain_of_attack(protocol_manipulation, 'Communication').

parent_of(protocol_manipulation, 'Reflection Attack in Authentication Protocol').
parent_of(protocol_manipulation, 'Client-Server Protocol Manipulation').
parent_of(protocol_manipulation, 'Inter-component Protocol Manipulation').
parent_of(protocol_manipulation, 'Data Interchange Protocol Manipulation').
parent_of(protocol_manipulation, 'Web Services Protocol Manipulation').

attack(protocol_manipulation, 'This type of attack can allow an adversary to impersonate others', 72).
attack(protocol_manipulation, 'This type of attack can allow an adversary to discover sensitive information', 52).
attack(protocol_manipulation, 'This type of attack can allow an adversary to control the outcome of a session', 37).
attack(protocol_manipulation, 'This type of attack can allow an adversary to perform other attacks', 34).

% Functionality Bypass - Abuse Existing Functionality

weakness(functionality_bypass, 'Improper Protection of Alternate Path').

mitigation(functionality_bypass, 'Mitigation for this attack is currently not available.').

domain_of_attack(functionality_bypass, 'Software').

parent_of(functionality_bypass, 'Calling Micro-Services Directly').
parent_of(functionality_bypass, 'Evercookie').
parent_of(functionality_bypass, 'Transparent Proxy Abuse').

attack(functionality_bypass, 'An adversary attacks a system by bypassing some or all functionality intended to protect it', 57).

% Fuzzing - Employ Probabilistic Techniques

weakness(fuzzing, 'Improper Neutralization of Special Elements in Output Used by a Downstream Component (Injection)').
weakness(fuzzing, '7PK - Errors').
weakness(fuzzing, 'Improper Input Validation').

mitigation(fuzzing, 'Test to ensure that the software behaves as per specification and that there are no unintended side effects. Ensure that no assumptions about the validity of data are made.').
mitigation(fuzzing, 'Use fuzz testing during the software QA process to uncover any surprises, uncover any assumptions or unexpected behavior.').

domain_of_attack(fuzzing, 'Software').

parent_of(fuzzing, 'Fuzzing for application mapping').

attack(fuzzing, 'Certain assumptions about user input can be detected.', 23).

% Brute Force - Employ Probabilistic Techniques

weakness(brute_force, 'Use of Insufficiently Random Values').
weakness(brute_force, 'Inadequate Encryption Strength').
weakness(brute_force, 'Weak Password Requirements').

mitigation(brute_force, 'Select a provably large secret space for selection of the secret. Provably large means that the procedure by which the secret is selected does not have artifacts that significantly reduce the size of the total secret space.').
mitigation(brute_force, 'Use a secret space that is well known and with no known patterns that may reduce functional size.').
mitigation(brute_force, 'Do not provide the means for an attacker to determine success independently. This forces the attacker to check their guesses against an external authority, which can slow the attack and warn the defender. This mitigation may not be possible if testing material must appear externally, such as with a transmitted cryptotext.').

domain_of_attack(brute_force, 'Software').

parent_of(brute_force, 'Encryption Brute Forcing').
parent_of(brute_force, 'Password Brute Forcing').

attack(brute_force, 'Attempts are made to access information, functionality, identity, etc.', 42).

% Buffer Manipulation - Manipulate Data Structures

weakness(buffer_manipulation, 'Improper Restriction of Operations within the Bounds of a Memory Buffer').

mitigation(buffer_manipulation, 'To help protect an application from buffer manipulation attacks, a number of potential mitigations can be leveraged. Before starting the development of the application, consider using a code language (e.g., Java) or compiler that limits the ability of developers to act beyond the bounds of a buffer. If the chosen language is susceptible to buffer related issues (e.g., C) then consider using secure functions instead of those vulnerable to buffer manipulations. If a potentially dangerous function must be used, make sure that proper boundary checking is performed. Additionally, there are often a number of compiler-based mechanisms (e.g., StackGuard, ProPolice and the Microsoft Visual Studio /GS flag) that can help identify and protect against potential buffer issues. Finally, there may be operating system level preventative functionality that can be applied.').

domain_of_attack(buffer_manipulation, 'Software').

parent_of(buffer_manipulation, 'Overflow Buffers').
parent_of(buffer_manipulation, 'Overread Buffers').

attack(buffer_manipulation, 'An adversary manipulates an applications interaction with a buffer in an attempt to read or modify data they shouldnt have access to.', 33).
attack(buffer_manipulation, 'most buffer attacks involve retrieving or providing more input than can be stored in the allocated buffer, resulting in the reading or overwriting of other unintended program memory.', 37).

% Shared Resource Manipulation - Manipulate Data Structures

weakness(shared_resource_manipulation, 'Improper Isolation of Shared Resources on System-on-a-Chip (SoC)').
weakness(shared_resource_manipulation, 'Improper Isolation of Shared Resources in Network On Chip').

mitigation(shared_resource_manipulation, 'Mitigation for this attack is currently not available.').

domain_of_attack(shared_resource_manipulation, 'Software').
domain_of_attack(shared_resource_manipulation, 'Hardware').

attack(shared_resource_manipulation, 'Resources may be shared between multiple applications or between multiple threads of a single application.', 26).
attack(shared_resource_manipulation, 'Disabled trust assumptions may occur.', 20).
attack(shared_resource_manipulation, 'Corruption of additional data can occur through the normal operations of other users of the shared resource.', 31).
attack(shared_resource_manipulation, 'Crash or compromise of the sharing applications can occur.', 35).

% Pointer Manipulation - Manipulate Data Structures

weakness(pointer_manipulation, 'Incorrect Calculation').
weakness(pointer_manipulation, 'Untrusted Pointer Dereference').
weakness(pointer_manipulation, 'Use of Out-of-range Pointer Offset').

mitigation(pointer_manipulation, 'Mitigation for this attack is currently not available.').

domain_of_attack(pointer_manipulation, 'Software').

attack(pointer_manipulation, 'The pointer is manipulated', 95).
attack(pointer_manipulation, 'An application accesses an unwanted memory location', 55).
attack(pointer_manipulation, 'An application crash may occur', 24).
attack(pointer_manipulation, 'It may be access to data that otherwise would not be possible', 44).
attack(pointer_manipulation, 'It can be executed arbitrary code', 23).

% Input Data Manipulation - Manipulate Data Structures

weakness(input_data_manipulation, 'Improper Input Validation').

mitigation(input_data_manipulation, 'Mitigation for this attack is currently not available.').

domain_of_attack(input_data_manipulation, 'Software').

parent_of(input_data_manipulation, 'Path Traversal').
parent_of(input_data_manipulation, 'Integer Attacks').
parent_of(input_data_manipulation, 'Leverage Alternate Encoding').

attack(input_data_manipulation, 'This is an attempt to control how the input is processed.', 96).
attack(input_data_manipulation, 'Using a different character encoding might cause dangerous text to be treated as safe text.', 45).
attack(input_data_manipulation, 'The attacker may use certain flags, such as file extensions, to make a target application believe that provided data should be handled using a certain interpreter when the data is not actually of the appropriate type.', 52).
attack(input_data_manipulation, 'Protective mechanisms can be bypassed.', 43).
attack(input_data_manipulation, 'The target may be forced to use certain input processing components.', 45).
attack(input_data_manipulation, 'User data may be handled differently than might otherwise be expected.', 32).

% Content Spoofing - Engage in Deceptive Interactions

weakness(content_spoofing, 'Insufficient Verification of Data Authenticity').

mitigation(content_spoofing, 'Mitigation for this attack is currently not available.').

domain_of_attack(content_spoofing, 'Software').
domain_of_attack(content_spoofing, 'Hardware').
domain_of_attack(content_spoofing, 'Communications').

parent_of(content_spoofing, 'Checksum Spoofing').
parent_of(content_spoofing, 'Spoofing of UDDI/ebXML Messages').
parent_of(content_spoofing, 'Intent Spoof').
parent_of(content_spoofing, 'Counterfeit GPS Signals').

attack(content_spoofing, 'Modifying content', 41).

% Identity Spoofing - Engage in Deceptive Interactions

weakness(identity_spoofing, 'Improper Authentication').

mitigation(identity_spoofing, 'Employ robust authentication processes (e.g., multi-factor authentication).').

domain_of_attack(identity_spoofing, 'Software').
domain_of_attack(identity_spoofing, 'Communications').
domain_of_attack(identity_spoofing, 'Social Engineering').

parent_of(identity_spoofing, 'Pharming').
parent_of(identity_spoofing, 'Phishing').
parent_of(identity_spoofing, 'Fake the Source of Data').
parent_of(identity_spoofing, 'Principal Spoof').
parent_of(identity_spoofing, 'Signature Spoof').

attack(identity_spoofing, 'Assuming the identity of some other entity', 67).

% Resource Location Spoofing - Engage in Deceptive Interactions

mitigation(resource_location_spoofing, 'Monitor network activity to detect any anomalous or unauthorized communication exchanges.').

domain_of_attack(resource_location_spoofing, 'Software').
domain_of_attack(resource_location_spoofing, 'Hardware').
domain_of_attack(resource_location_spoofing, 'Communications').
domain_of_attack(resource_location_spoofing, 'Social Engineering').

parent_of(resource_location_spoofing, 'Redirect Access to Libraries').
parent_of(resource_location_spoofing, 'Establish Rogue Location').

attack(resource_location_spoofing, 'Deceiving an application or user and convincing them to request a resource from an unintended location', 33). 

% Action Spoofing - Engage in Deceptive Interactions

mitigation(action_spoofing, 'Avoid interacting with suspicious sites or clicking suspicious links.').
mitigation(action_spoofing, 'An organization should provide regular, robust cybersecurity training to its employees.').

domain_of_attack(action_spoofing, 'Software').
domain_of_attack(action_spoofing, 'Social Engineering').

parent_of(action_spoofing, 'Clickjacking').
parent_of(action_spoofing, 'Android Activity Hijack').
parent_of(action_spoofing, 'Task Impresonation').
parent_of(action_spoofing, 'Tapjacking').

attack(action_spoofing, 'Tricking a user into initiating one type of action when they inted to initiate a different action', 85).

% Manipulate Human Behavior - Engage in Deceptive Interactions

mitigation(manipulate_human_behavior, 'An organization should provide regular, robust cybersecurity training to its employees to prevent successful social engineering attacks.').

domain_of_attack(manipulate_human_behavior, 'Social Engineering').

parent_of(manipulate_human_behavior, 'Pretexting').
parent_of(manipulate_human_behavior, 'Influence Perception').
parent_of(manipulate_human_behavior, 'Target Influence via Framing').
parent_of(manipulate_human_behavior, 'Influence via Incentives').
parent_of(manipulate_human_behavior, 'Influence via Psychological Principles').

attack(manipulate_human_behavior, 'Exploiting inherent human psychological predisposition to influence a targeted individual or group to solicit information or manipulate the target into performing an action that serves the interests of an adversary', 75).

% Infrastructure Manipulation - Manipulate System Resources

mitigation(infrastructure_manipulation, 'Mitigation for this attack is currently not available.').

domain_of_attack(infrastructure_manipulation, 'Software').
domain_of_attack(infrastructure_manipulation, 'Hardware').
domain_of_attack(infrastructure_manipulation, 'Communications').

parent_of(infrastructure_manipulation, 'Cache Poisoning').
parent_of(infrastructure_manipulation, 'Force the System to Reset Values').
parent_of(infrastructure_manipulation, 'Audit Log Manipulation').
parent_of(infrastructure_manipulation, 'Contradictory Destinations in Traffic Routing Schemes').
parent_of(infrastructure_manipulation, 'Block Logging to Central Repository').

attack(infrastructure_manipulation, 'Exploiting characteristics of the infrastructure of a network entity in order to perpetrate attacks or information gathering on network objects or effect a change in the ordinary information flow between network objects', 72).

% File Manipulation - Manipulate System Resources

mitigation(file_manipulation, 'Mitigation for this attack is currently not available.').

domain_of_attack(file_manipulation, 'Software').

parent_of(file_manipulation, 'User-Controlled Filename').
parent_of(file_manipulation, 'Artificially Inflate File Sizes').
parent_of(file_manipulation, 'Alternative Execution Due to Deceptive Filenames').
parent_of(file_manipulation, 'Hiding Malicious Data or Code within Files').

attack(file_manipulation, 'Modifying file contents or attributes (such as extensions or names) of files in a manner to cause incorrect processing by an application', 58).
attack(file_manipulation, 'Causing applications to enter unstable states, overwrite or expose sensitive information, and even execute arbitrary code with the applications privileges', 62).

% Configuration/Environment Manipulation - Manipulate System Resources

weakness(configuration/environment_manipulation, 'External Control of System or Configuration Setting').
weakness(configuration/environment_manipulation, 'Improper Hardware Lock Protection for Security Sensitive Controls').
weakness(configuration/environment_manipulation, 'Hardware Internal or Debug Modes Allow Override of Locks').

mitigation(configuration/environment_manipulation, 'Mitigation for this attack is currently not available.').

domain_of_attack(configuration/environment_manipulation, 'Software').
domain_of_attack(configuration/environment_manipulation, 'Hardware').
domain_of_attack(configuration/environment_manipulation, 'Supply Chain').

parent_of(configuration/environment_manipulation, 'Manipulating Writeable Configuration Files').
parent_of(configuration/environment_manipulation, 'Manipulate Registry Information').
parent_of(configuration/environment_manipulation, 'Schema Poisoning').
parent_of(configuration/environment_manipulation, 'Data Injected During Configuration').
parent_of(configuration/environment_manipulation, 'Disable Security Software').

attack(configuration/environment_manipulation, 'Manipulating files or settings external to a target application which affect the behavior of that application', 64).

% Software Integrity Attack - Manipulate System Resources

weakness(software_integrity_attack, 'Download of Code Without Integrity Check').

mitigation(software_integrity_attack, 'Mitigation for this attack is currently not available.').

domain_of_attack(software_integrity_attack, 'Software').
domain_of_attack(software_integrity_attack, 'Social Engineering').

parent_of(software_integrity_attack, 'Malicious Software Download').
parent_of(software_integrity_attack, 'Malicious Software Update').

attack(software_integrity_attack, 'Initiating a series of events designed to cause a user, program, server, or device to perform actions which undermine the integrity of software code, device data structures, or device firmware, achieving the modification of the targets integrity to achieve an insecure state.', 91).

% Modification During Manufacture - Manipulate System Resources

mitigation(modification_during_manufacture, 'Mitigation for this attack is currently not available.').

domain_of_attack(modification_during_manufacture, 'Software').
domain_of_attack(modification_during_manufacture, 'Hardware').
domain_of_attack(modification_during_manufacture, 'Supply Chain').

parent_of(modification_during_manufacture, 'Development Alteration').
parent_of(modification_during_manufacture, 'Design Alteration').

attack(modification_during_manufacture, 'Modifying a technology, product, or component during a stage in its manufacture for the purpose of carrying out an attack against some entity involved in the supply chain lifecycle.', 86).

% Manipulation During Distribution - Manipulate System Resources

weakness(manipulation_during_distribution, 'Product Released in Non-Release Configuration').

mitigation(manipulation_during_distribution, 'Mitigation for this attack is currently not available.').

domain_of_attack(manipulation_during_distribution, 'Hardware').
domain_of_attack(manipulation_during_distribution, 'Supply Chain').

parent_of(manipulation_during_distribution, 'Malicious Hardware Component Replacement').
parent_of(manipulation_during_distribution, 'Malicious Software Implanted').
parent_of(manipulation_during_distribution, 'Rogue Integration Procedures').

attack(manipulation_during_distribution, 'Undermining the integrity of a product, software, or technology at some stage of the distribution channel', 67).

% Hardware Integrity Attack - Manipulate System Resources

mitigation(hardware_integrity_attack, 'Mitigation for this attack is currently not available.').

domain_of_attack(hardware_integrity_attack, 'Hardware').
domain_of_attack(hardware_integrity_attack, 'Supply Chain').
domain_of_attack(hardware_integrity_attack, 'Physical Security').

parent_of(hardware_integrity_attack, 'Physically Hacking Hardware').
parent_of(hardware_integrity_attack, 'Malicious Hardware Update').

attack(hardware_integrity_attack, 'Exploiting a weakness in the system maintenance process and causing a change to be made to a technology, product, component, or sub-component or a new one installed during its deployed use at the victim location for the purpose of carrying out an attack', 73).

% Malicious Logic Insertion - Manipulate System Resources

weakness(malicious_logic_insertion, 'Improper Access Control').

mitigation(malicious_logic_insertion, 'Mitigation for this attack is currently not available.').

domain_of_attack(malicious_logic_insertion, 'Software').
domain_of_attack(malicious_logic_insertion, 'Hardware').
domain_of_attack(malicious_logic_insertion, 'Supply Chain').

parent_of(malicious_logic_insertion, 'Infected Software').
parent_of(malicious_logic_insertion, 'Infected Hardware').
parent_of(malicious_logic_insertion, 'Infected Memory').

attack(malicious_logic_insertion, 'Installing or adding malicious logic (also known as malware) into a seemingly benign component of a fielded system', 78).

% Contaminate Resource - Manipulate System Resources

mitigation(contaminate_resource, 'Mitigation for this attack is currently not available.').

domain_of_attack(contaminate_resource, 'Software').
domain_of_attack(contaminate_resource, 'Hardware').

attack(contaminate_resource, 'Contaminating organizational information systems (including devices and networks) by causing them to handle information of a classification/sensitivity for which they have not been authorized. The information is exposed to individuals who are not authorized access to such information, and the information system, device, or network is unavailable while the spill is investigated and mitigated.', 85).

% Obstruction - Manipulate System Resources

mitigation(obstruction, 'Mitigation for this attack is currently not available.').

domain_of_attack(obstruction, 'Software').
domain_of_attack(obstruction, 'Hardware').
domain_of_attack(obstruction, 'Communications').
domain_of_attack(obstruction, 'Social Engineering').
domain_of_attack(obstruction, 'Physical Security').

parent_of(obstruction, 'Physical Destruction of Device or Component').
parent_of(obstruction, 'Route Disabling').
parent_of(obstruction, 'Jamming').
parent_of(obstruction, 'Blockage').

attack(obstruction, 'Obstructing the interactions between system components. By interrupting or disabling these interactions, an adversary can often force the system into a degraded state or even to fail.', 94).

% Parameter Injection - Inject Unexpected Items

weakness(parameter_injection, 'Improper Neutralization of Argument Delimiters in a Command (Argument Injection)').

mitigation(parameter_injection, 'Implement an audit log written to a separate host. In the event of a compromise, the audit log may be able to provide evidence and details of the compromise. Treat all user input as untrusted data that must be validated before use.').

domain_of_attack(parameter_injection, 'Software').
domain_of_attack(parameter_injection, 'Social Engineering').

parent_of(parameter_injection, 'Argument Injection').
parent_of(parameter_injection, 'Command Delimiters').
parent_of(parameter_injection, 'Email Injection').
parent_of(parameter_injection, 'Format String Injection').
parent_of(parameter_injection, 'Reflection Injection').
parent_of(parameter_injection, 'Flash Injection').

attack(parameter_injection, 'The targeted application do not use a parametar encoding', 20).

% Code Inclusion - Inject Unexpected Items

weakness(code_inclusion, 'Inclusion of Functionality from Untrusted Control Sphere').

mitigation(code_inclusion, 'Mitigation for this attack is currently not available.').

domain_of_attack(code_inclusion, 'Software').

parent_of(code_inclusion, 'Local Code Inclusion').
parent_of(code_inclusion, 'Remote Code Inclusion').

attack(code_inclusion, 'Does application include external code/libraries that are executed when the application runs and is it possible to influence the specific files that get included', 15). 

% Resource Injection - Inject Unexpected Items

weakness(resource_injection, 'Improper Control of Resource Identifiers (Resource Injection)').

mitigation(resource_injection, 'Ensure all input content that is delivered to client is sanitized against an acceptable content specification. Perform input validation for all content. Enforce regular patching of software'). 

domain_of_attack(resource_injection, 'Software').
domain_of_attack(resource_injection, 'Communications').

parent_of(resource_injection, 'Cellular Data Injection').

attack(resource_injection, 'Resource should failed validation', 25).
attack(resource_injection, 'Is possible to manipulate resource validation', 22).

% Code Injection - Inject Unexpected Items

weakness(code_injection, 'Improper Control of Generation of Code (Code Injection)').

mitigation(code_injection, 'Utilize strict type, character, and encoding enforcement'). 
mitigation(code_injection, 'Ensure all input content that is delivered to client is sanitized against an acceptable content specification.'). 
mitigation(code_injection, 'Perform input validation for all content.'). 
mitigation(code_injection, 'Enforce regular patching of software.'). 

domain_of_attack(code_injection, 'Software').

parent_of(code_injection, 'Embedding Scripts within Scripts').
parent_of(code_injection, 'File Content Injection').
parent_of(code_injection, 'Using Meta-characters in E-mail Headers to Inject Malicious Payloads').
parent_of(code_injection, 'Cross-Site Scripting (XSS)').
parent_of(code_injection, 'Generic Cross-Browser Cross-Domain Theft').

attack(code_injection, 'The target software does not validate user input', 42).

% Command Injection - Inject Unexpected Items

weakness(command_injection, 'Improper Neutralization of Special Elements used in a Command (Command Injection)').

mitigation(command_injection, 'All user-controllable input should be validated and filtered for potentially unwanted characters. Using an allowlist for input is desired, but if use of a denylist approach is necessary, then focusing on command related terms and delimiters is necessary.'). 
mitigation(command_injection, 'Input should be encoded prior to use in commands to make sure command related characters are not treated as part of the command. For example, quotation characters may need to be encoded so that the application does not treat the quotation as a delimiter.'). 
mitigation(command_injection, 'Input should be parameterized, or restricted to data sections of a command, thus removing the chance that the input will be treated as part of the command itself.'). 

domain_of_attack(command_injection, 'Software').

parent_of(command_injection, 'Manipulating Writeable Terminal Devices').
parent_of(command_injection, 'SQL Injection').
parent_of(command_injection, 'OS Command Injection').
parent_of(command_injection, 'LDAP Injection').
parent_of(command_injection, 'IMAP/SMTP Command Injection').
parent_of(command_injection, 'XML Injection').

attack(command_injection, 'The target software does not validate user input', 62).
attack(command_injection, 'Is execute unauthorized commands', 36).

% Local Execution of Code - Inject Unexpected Items

weakness(local_execution_of_code, 'Inclusion of Functionality from Untrusted Control Sphere').

mitigation(local_execution_of_code, 'Employ robust cybersecurity training for all employees.'). 
mitigation(local_execution_of_code, 'Implement system antivirus software that scans all attachments before opening them.'). 
mitigation(local_execution_of_code, 'Regularly patch all software.'). 
mitigation(local_execution_of_code, 'Execute all suspicious files in a sandbox environment.'). 

domain_of_attack(local_execution_of_code, 'Software').

parent_of(local_execution_of_code, 'Targeted Malware').
can_follow(local_execution_of_code, 'Windows Admin Shares with Stolen Credentials').
can_follow(local_execution_of_code, 'Use of Captured Hashes (Pass The Hash)').

attack(local_execution_of_code, 'Negative technical impact', 49).

% Object Injection - Inject Unexpected Items

weakness(object_injection, 'Deserialization of Untrusted Data').

mitigation(object_injection, 'Implementation: Validate object before deserialization process'). 
mitigation(object_injection, 'Design: Limit which types can be deserialized.'). 
mitigation(object_injection, 'Implementation: Avoid having unnecessary types or gadgets available that can be leveraged for malicious ends. Use an allowlist of acceptable classes.'). 
mitigation(object_injection, 'Implementation: Keep session state on the server, when possible.'). 

domain_of_attack(object_injection, 'Software').

attack(object_injection, 'Adversary can potentially compromise the application by manipulating the deserialization process', 19).
attack(object_injection, 'Remote code execution', 21).

% Traffic Injection - Inject Unexpected Items

weakness(traffic_injection, 'Improper Verification of Source of a Communication Channel').

mitigation(traffic_injection, 'Mitigation for this attack is currently not available.').

domain_of_attack(traffic_injection, 'Software').
domain_of_attack(traffic_injection, 'Communications').

parent_of(traffic_injection, 'Connection Reset').

attack(traffic_injection, 'Adversary is able to degrade or disrupt the connection, and potentially modify the content', 81).

% Hardware Fault Injection - Inject Unexpected Items

weakness(hardware_fault_injection, 'Missing or Improperly Implemented Protection Against Voltage and Clock Glitches').
weakness(hardware_fault_injection, 'Semiconductor Defects in Hardware Logic with Security-Sensitive Implications').
weakness(hardware_fault_injection, 'Hardware Features Enable Physical Attacks from Software').
weakness(hardware_fault_injection, 'Improper Protection against Electromagnetic Fault Injection (EM-FI)').
weakness(hardware_fault_injection, 'Insufficient Protection Against Instruction Skipping Via Fault Injection').
weakness(hardware_fault_injection, 'Unauthorized Error Injection Can Degrade Hardware Redundancy').

mitigation(hardware_fault_injection, 'Implement robust physical security countermeasures and monitoring.').

domain_of_attack(hardware_fault_injection, 'Hardware').
domain_of_attack(hardware_fault_injection, 'Communications').

parent_of(hardware_fault_injection, 'Mobile Device Fault Injection').

attack(hardware_fault_injection, 'Did other device has physical access to the device', 76).

% RULES

weaknesses(Attack, Weaknesses) :- weakness(Attack, Weaknesses).
mitigations(Attack, Mitigations) :- mitigation(Attack, Mitigations).
domains_of_attack(Attack, Domains_of_attack) :- domain_of_attack(Attack, Domains_of_attack).
parent_of_relationships(Attack, Relationships) :- parent_of(Attack, Relationships).
can_follow_relationships(Attack, Relationships) :- can_follow(Attack, Relationships).
attack_information(Attack, Negative_impact_of_an_attack, Probability) :- attack(Attack, Negative_impact_of_an_attack, Probability).

This is source code from http://hdl.handle.net/10909/11031 which was uncompiled
using the rather miraculous Java decomplier here: http://jd.benow.ca. If you
find the source code helpful, please donate to the author of the decompiler.
I donated $20 for the amazing piece of software that made this possible.

Notes: I didn't grab all the dependencies and config for deployment. It will be
found in the original location.

LICENSE: US GOVEREMENT AUTHORED SOFTWARE. PUBLIC DOMAIN

Quick notes from the docs:
MOCHA 3.0 Server goes with MOCHA Client 2.1 (??--why? oh well).

This release does this:

 * RTC Story ID# 32517 – New clinical route added – 114 INTRAVARICEAL shall be addressed by Functional Requirement 2.6.1.1.2.
 * Three tables within MOCHA Server shall be updated. 
   * The Dose Units table shall be updated.
   * The Dose Routes table shall be updated.
   * The Dose Types table shall be updated.
 * The system shall return the MaxDailyDose, MaxDailyDoseUnit, MaxDailyDoseForm, and MaxDailyDoseFormUnit fields in the response back to VistA when performing a Drug-Dose order check.
 * TRM Complicance Upgrades
   * WebLogic 10.3.6 -> 12c
   * Java 6 -> 7
   * Newer Jars for JAXB
   * JDBC 6 -> 7


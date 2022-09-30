# ESP

The *ESP* (Expert system for Software Protection) is our answer to the question *can a computer optimally protect a
software binary?* The ESP started its life in the ASPIRE FP7 project (https://aspire-fp7.eu/) during which it was known
as the ADSS (ASPIRE Decision Support System).

The ESP is implemented mostly in Java as a series of Eclipse (https://www.eclipse.org/) plug-ins. It can be used to
automatically protect programs written in C or C++ using the software protections developed during the ASPIRE project
and the Tigress obfuscator (https://tigress.wtf/).

## Structure

This is the project structure:

- `it.polito.security.esp` contains the main classes and most of the internal logic modules of the ESP;
- `it.polito.security.esp.kb` contains the knowledge base classes;
- `it.polito.security.esp.rules` contains the parser for the custom protection rules;
- `it.polito.security.esp.rules.ide` contains the Eclipse integration classes for the protection rules editor;
- `it.polito.security.esp.rules.ui` contains the Eclipse UI classes for the protection rules editor;
- `it.polito.security.esp.ui` contains most of the Eclipse UI classes of the ESP;
- `it.polito.security.esp.util` contains several utility classes.
- `reports` contains the original ADSS reports that we generated for the three ASPIRE use cases:
    - `DemoPlayer.html` is the report for a video streaming library for the Nagra Kudelski
      Group (https://www.nagra.com/);
    - `LicenseManager.html` is the report for a license managing library for the SafeNet Inc., now Thales
      Group (https://www.thalesgroup.com/);
    - `OTP.html` is the report for a one time password application for Gemalto N. V., now Thales
      Group (https://www.thalesgroup.com/).

## Resources

Some additional resources about the ESP/ADSS:

- *Demonstration of the ASPIRE Decision Support System - Full*,
  https://www.youtube.com/watch?v=pl9p5Nqsx_o:
  full demo of the ADSS in action during the ASPIRE days;
- *D5.13 - ASPIRE Open Source Manual*,
  https://aspire-fp7.eu/sites/default/files/D5.13-ASPIRE-Open-Source-Manual.pdf:
  this document contains a description of the ESP/ADSS, its installation guide and the user manual.

If you want to cite our work, these are our publications regarding the ESP/ADSS:

- Leonardo Regano,
  *An Expert System for Automatic Software Protection*,
  PhD thesis, 2019,
  https://iris.polito.it/retrieve/handle/11583/2751495/270821/Regano_PhD_Thesis.pdf;
- Cataldo Basile, Daniele Canavese, Leonardo Regano, Paolo Falcarin, Bjorn De Sutter,
  *A meta-model for software protections and reverse engineering attacks*,
  Journal of Systems and Software, vol. 150,
  https://doi.org/10.1016/j.jss.2018.12.025;
- Daniele Canavese, Leonardo Regano, Cataldo Basile, Alessio Viticchié,
  *Estimating Software Obfuscation Potency with Artificial Neural Networks*,
  STM 2017: International Workshop on Security and Trust Management,
  https://doi.org/10.1007/978-3-319-68063-7_13;
- Leonardo Regano, Daniele Canavese, Cataldo Basile, Antonio Lioy,
  *Towards Optimally Hiding Protected Assets in Software Applications*,
  QRS 2017: International Conference on Software Quality, Reliability and Security,
  https://doi.org/10.1109/QRS.2017.47;
- Leonardo Regano, Daniele Canavese, Cataldo Basile, Alessio Viticchié, Antonio Lioy,
  *Towards Automatic Risk Analysis and Mitigation of Software Applications*,
  WISTP 2016: International Conference on Information Security Theory and Practice,
  https://doi.org/10.1007/978-3-319-45931-8_8;
- Cataldo Basile, Daniele Canavese, Jerome D'Annoville, Bjorn De Sutter, Fulvio Valenza,
  *Automatic discovery of software attacks via backward reasoning*,
  SPRO 2015: International Workshop on Software Protection,
  https://doi.org/10.1109/SPRO.2015.17.

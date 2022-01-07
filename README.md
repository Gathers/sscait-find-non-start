# sscait-find-non-start

A quick and dirty Clojure script for finding games where the replay is only available for one bot.

## Usage

To run from REPL:

        git clone https://github.com/Gathers/sscait-find-non-start.git
        cd sscait-find-non-start
        lein repl
        (load-file "src/sscait_find_non_start/core.clj")

The *fetch-url* function uses memoize to cache downloaded files, so you can use it multiple times from the REPL but it will only download each URL once.

## Results

This was the output last time I ran it at 2022-01-07:

        Found 161 possibly dropped games out of a total of 1043 games from 55 bots.
        ("0004-Ecgb_Mega-TvP.rep" "0018-AURE_MCRA-ZVZ.REP" "0029-Kaon_Mega-TvP.rep" "0030-SIJI_WILL-ZVT.REP" "0039-FLOR_NUIB-PVZ.REP" "0040-Yuan_Siji-PvZ.rep" "0046-Hao _Jaku-TvP.rep" "0050-Bana_Stea-PvZ.rep" "0054-CUBO_Iron-ZvT.rep" "0059-SIJI_MONS-ZVZ.REP" "0069-Stea_Hao -ZvT.rep" "0089-Simp_insa-ZvT.rep" "0094-Flas_MadM-PvP.rep" "0095-ANDR_MCRA-PVZ.REP" "0101-Kaon_NuiB-TvZ.rep" "0103-Bana_Yuan-PvP.rep" "0110-Junk_insa-TvT.rep" "0129-ZurZ_Siji-ZvZ.rep" "0130-Kaso_Star-TvP.rep" "0131-Bori_Simp-ZvZ.rep" "0132-Chri_Styx-ZvZ.rep" "0134-SOER_XIAO-TVT.REP" "0137-Brya_Path-ZvZ.rep" "0138-AURE_ZURZ-ZVZ.REP" "0156-Will_Jaku-TvP.rep" "0162-TOMA_MEGA-PVP.REP" "0163-Jump_Jaku-ZvP.rep" "0165-Stea_Star-ZvP.rep" "0166-AURE_INSA-ZVT.REP" "0183-Micr_MadM-ZvP.rep" "0190-SOER_JAKU-TVP.REP" "0209-AURE_JAKU-ZVP.REP" "0218-XIAO_insa-TvT.rep" "0229-ICEL_STYX-TVZ.REP" "0230-Dave_Mega-RvP.rep" "0236-FLOR_JAKU-PVP.REP" "0244-Junk_Micr-TvZ.rep" "0245-Styx_Star-ZvP.rep" "0275-Hao _Flor-TvP.rep" "0278-ANDR_JAKU-PVP.REP" "0279-MEGA_FLAS-PVP.REP" "0310-kras_NLPR-PvZ.rep" "0313-AILi_Soer-ZvT.rep" "0316-Bori_Luka-ZvP.rep" "0317-Brya_Dave-ZvR.rep" "0330-Hao _Mons-TvZ.rep" "0331-Nite_Junk-TvT.rep" "0333-Brya_Drag-ZvT.rep" "0337-MART_FLOR-TVP.REP" "0347-NuiB_Flor-ZvP.rep" "0349-Wuli_Toma-PvP.rep" "0365-ANDR_PURP-PVP.REP" "0367-MadM_Dave-PvR.rep" "0387-Mons_Toma-ZvP.rep" "0388-Mari_Toma-TvP.rep" "0392-Mari_AILi-TvZ.rep" "0401-Prox_Flas-ZvP.rep" "0402-Iron_Beta-TvP.rep" "0406-Flas_Jaku-PvP.rep" "0417-AILi_Jaku-ZvP.rep" "0431-Beta_Jaku-PvP.rep" "0450-MATE_JAKU-TVP.REP" "0461-Flas_Jaku-PvP.rep" "0478-insa_McRa-TvZ.rep" "0482-TOMA_FLOR-PVP.REP" "0484-Star_TyrP-PvP.rep" "0490-MadM_TyrP-PvP.rep" "0491-lega_Simp-RvZ.rep" "0492-FLOR_WILL-PVT.REP" "0502-Bana_insa-PvT.rep" "0512-MEGA_NITE-PVT.REP" "0514-MATE_SOER-TVT.REP" "0521-Star_Purp-PvP.rep" "0523-XIAO_Bana-TvP.rep" "0535-NLPR_Jaku-ZvP.rep" "0536-XIAO_Mons-TvZ.rep" "0540-Mari_McRa-TvZ.rep" "0544-Prox_Jaku-ZvP.rep" "0547-Styx_Jaku-ZvP.rep" "0553-Iron_Jaku-TvP.rep" "0559-Wuli_Jaku-PvP.rep" "0576-Arra_Jaku-ZvP.rep" "0579-MEGA_TOMA-PVP.REP" "0580-Stea_insa-ZvT.rep" "0591-insa_Toma-TvP.rep" "0598-SOER_MEGA-TVP.REP" "0619-Yuan_MadM-PvP.rep" "0620-Ecgb_Arra-TvZ.rep" "0621-McRa_Flas-ZvP.rep" "0634-MATE_DAVE-TVR.REP" "0635-Nite_Jaku-TvP.rep" "0636-ICEL_MCRA-TVZ.REP" "0643-MART_JAKU-TVP.REP" "0644-Star_Jaku-PvP.rep" "0649-Mons_Jaku-ZvP.rep" "0650-Bana_Jaku-PvP.rep" "0652-Iron_Jaku-TvP.rep" "0663-Micr_Mega-ZvP.rep" "0679-MEGA_MONS-PVZ.REP" "0680-lega_Kaso-RvT.rep" "0681-Nite_Jaku-TvP.rep" "0682-CUBO_Prox-ZvZ.rep" "0689-AILi_Siji-ZvZ.rep" "0690-McRa_Drag-ZvT.rep" "0691-TOMA_JUNK-PVT.REP" "0698-Purp_Jaku-PvP.rep" "0703-SIJI_JAKU-ZVP.REP" "0708-Styx_Jaku-ZvP.rep" "0714-Brya_AILi-ZvZ.rep" "0724-NuiB_Star-ZvP.rep" "0725-Star_CUBO-PvZ.rep" "0726-TOMA_AURE-PVZ.REP" "0749-ZurZ_Jaku-ZvP.rep" "0757-NLPR_Mega-ZvP.rep" "0763-Beta_Flas-PvP.rep" "0769-TOMA_STAR-PVP.REP" "0771-Path_Toma-ZvP.rep" "0772-MATE_PURP-TVP.REP" "0785-FLOR_BETA-PVP.REP" "0786-lega_Beta-RvP.rep" "0787-insa_CUBO-TvZ.rep" "0802-McRa_AILi-ZvZ.rep" "0805-Brya_Purp-ZvP.rep" "0816-Will_AILi-TvZ.rep" "0824-TyrP_Flor-PvP.rep" "0825-Wuli_Jaku-PvP.rep" "0842-Flas_Flor-PvP.rep" "0847-Simp_Ecgb-ZvT.rep" "0853-Luka_Andr-PvP.rep" "0859-Simp_Flor-ZvP.rep" "0868-SOER_INSA-TVT.REP" "0873-ANDR_MEGA-PVP.REP" "0874-XIAO_Mega-TvP.rep" "0875-TyrP_Toma-PvP.rep" "0906-TyrP_Jaku-PvP.rep" "0907-Hao _Mega-TvP.rep" "0912-Micr_Jaku-ZvP.rep" "0929-AURE_NUIB-ZVZ.REP" "0933-kras_Yuan-PvP.rep" "0936-Bana_Micr-PvZ.rep" "0950-Kaon_TyrP-TvP.rep" "0963-Simp_insa-ZvT.rep" "0974-Chri_insa-ZvT.rep" "0981-MART_JAKU-TVP.REP" "0982-insa_Kaon-TvT.rep" "0998-McRa_insa-ZvT.rep" "1001-lega_Toma-RvP.rep" "1003-MATE_WILL-TVT.REP" "1004-Iron_Dave-TvR.rep" "1005-MATE_MONS-TVZ.REP" "1013-Bana_Drag-PvT.rep" "1015-MART_KASO-TVT.REP" "1017-AILi_Jaku-ZvP.rep" "1028-Dave_Purp-RvP.rep" "1033-Hao _Jaku-TvP.rep" "1039-Kaso_Beta-TvP.rep" "1040-MEGA_MATE-PVT.REP" "1041-Iron_McRa-TvZ.rep" "1043-Stea_Yuan-ZvP.rep" "1048-MadM_Drag-PvT.rep" "1059-Prox_insa-ZvT.rep")
        ([JAKU 35] [INSA 11] [MEGA 10] [TOMA 8] [FLOR 7] [MCRA 6] [PURP 5] [MONS 5] [STAR 5] [BETA 4] [DAVE 4] [FLAS 4] [DRAG 4] [AILI 4] [MADM 3] [SIJI 3] [WILL 3] [YUAN 3] [TYRP 3] [NUIB 3] [STYX 2] [SIMP 2] [MICR 2] [KASO 2] [SOER 2] [JUNK 2] [CUBO 2] [IRON 1] [NLPR 1] [XIAO 1] [ANDR 1] [ECGB 1] [ZURZ 1] [MATE 1] [ARRA 1] [STEA 1] [LUKA 1] [HAO  1] [KAON 1] [PROX 1] [PATH 1] [AURE 1] [NITE 1] [BANA 1])

It seems like *Jakub Trancik* ends most games in a crash and should be regarded as a false positive.

## License

The Unlicense, do whatever.

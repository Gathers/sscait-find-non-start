# sscait-find-non-start

A quick and dirty Clojure script for finding games where the replay is only available for one bot.

## Usage

Run from REPL?

The *fetch-url* function uses memoize to cache downloaded files, so you can execute the script multiple times but it will only download each URL once.

## Results

This was the output last time I ran it at 2022-01-03:

        Found 69 possibly dropped games out of a total of 484 games from 55 bots.
        ("0004-Ecgb_Mega-TvP.rep" "0018-AURE_MCRA-ZVZ.REP" "0029-Kaon_Mega-TvP.rep" "0030-SIJI_WILL-ZVT.REP" "0039-FLOR_NUIB-PVZ.REP" "0040-Yuan_Siji-PvZ.rep" "0046-Hao _Jaku-TvP.rep" "0050-Bana_Stea-PvZ.rep" "0054-CUBO_Iron-ZvT.rep" "0059-SIJI_MONS-ZVZ.REP" "0069-Stea_Hao -ZvT.rep" "0089-Simp_insa-ZvT.rep" "0094-Flas_MadM-PvP.rep" "0095-ANDR_MCRA-PVZ.REP" "0101-Kaon_NuiB-TvZ.rep" "0103-Bana_Yuan-PvP.rep" "0110-Junk_insa-TvT.rep" "0129-ZurZ_Siji-ZvZ.rep" "0130-Kaso_Star-TvP.rep" "0131-Bori_Simp-ZvZ.rep" "0132-Chri_Styx-ZvZ.rep" "0134-SOER_XIAO-TVT.REP" "0137-Brya_Path-ZvZ.rep" "0138-AURE_ZURZ-ZVZ.REP" "0156-Will_Jaku-TvP.rep" "0162-TOMA_MEGA-PVP.REP" "0163-Jump_Jaku-ZvP.rep" "0165-Stea_Star-ZvP.rep" "0166-AURE_INSA-ZVT.REP" "0183-Micr_MadM-ZvP.rep" "0190-SOER_JAKU-TVP.REP" "0209-AURE_JAKU-ZVP.REP" "0218-XIAO_insa-TvT.rep" "0229-ICEL_STYX-TVZ.REP" "0230-Dave_Mega-RvP.rep" "0236-FLOR_JAKU-PVP.REP" "0244-Junk_Micr-TvZ.rep" "0245-Styx_Star-ZvP.rep" "0275-Hao _Flor-TvP.rep" "0278-ANDR_JAKU-PVP.REP" "0279-MEGA_FLAS-PVP.REP" "0310-kras_NLPR-PvZ.rep" "0313-AILi_Soer-ZvT.rep" "0316-Bori_Luka-ZvP.rep" "0317-Brya_Dave-ZvR.rep" "0330-Hao _Mons-TvZ.rep" "0331-Nite_Junk-TvT.rep" "0333-Brya_Drag-ZvT.rep" "0337-MART_FLOR-TVP.REP" "0347-NuiB_Flor-ZvP.rep" "0349-Wuli_Toma-PvP.rep" "0365-ANDR_PURP-PVP.REP" "0367-MadM_Dave-PvR.rep" "0387-Mons_Toma-ZvP.rep" "0388-Mari_Toma-TvP.rep" "0392-Mari_AILi-TvZ.rep" "0401-Prox_Flas-ZvP.rep" "0402-Iron_Beta-TvP.rep" "0406-Flas_Jaku-PvP.rep" "0417-AILi_Jaku-ZvP.rep" "0431-Beta_Jaku-PvP.rep" "0450-MATE_JAKU-TVP.REP" "0461-Flas_Jaku-PvP.rep" "0478-insa_McRa-TvZ.rep" "0482-TOMA_FLOR-PVP.REP" "0484-Star_TyrP-PvP.rep" "0490-MadM_TyrP-PvP.rep" "0491-lega_Simp-RvZ.rep" "0492-FLOR_WILL-PVT.REP")

## License

The Unlicense, do whatever.

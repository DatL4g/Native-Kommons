package dev.datlag.kommons


data object SaintPierreAndMiquelon : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("PM")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SPM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(666)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(508)
}